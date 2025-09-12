import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       //케빈 베이컨의 6단계
        //케빈 베이컨의 수가 가장 작은 사람
        //케빈 베이컨의 수 + 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합
        //BOJ 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람을 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] chars = br.readLine().split(" ");
            int from = Integer.parseInt(chars[0]), to = Integer.parseInt(chars[1]);
            //무방향 그래프
            adj[from].add(to);
            adj[to].add(from);
        }

        //오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        int answer = 1;
        int bestSum = Integer.MAX_VALUE;

        //각 유저 i에 대해 케빈 베이컨 수(최단거리 합) 계산
        for (int i = 1; i <= N; i++) {
            int sum = kebin_dfs(adj, N, i);
            if (sum < bestSum) {
                bestSum = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    //i번 유저에서 모든 유저까지의 최단거리 합
    static int kebin_dfs(List<Integer>[] adj, int N, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 1_000_000);
        dfsRelax(adj, start, 0, dist);
        int sum =0;
        for (int v = 1; v <= N; v++) sum += dist[v];
        return sum;
    }

    //DFS로 최단거리 완화(relax) : 더 짧게 도달할 때만 진행 (가지치기)
    static void dfsRelax(List<Integer>[] adj, int cur, int depth, int[] dist) {
        if(depth >= dist[cur]) return;
        dist[cur] = depth; //최단 갱신
        for (int next : adj[cur]) {
            if (depth + 1 < dist[next]) {
                dfsRelax(adj, next, depth + 1, dist);
            }
        }

    }

}
