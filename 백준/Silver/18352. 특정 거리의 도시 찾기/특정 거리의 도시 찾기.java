import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N + 1];//1~N
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        //방향 그래프
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // u -> v (가중치 1)
            adj[u].add(v);
        }
        bfs(adj, K, X);
        System.out.print(sb.length()==0 ? -1 : sb);
    }

    static void bfs(ArrayList<Integer>[] adj, int K, int X) {
        int N = adj.length-1;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1); //방문 처리 용도. 방문 하지 않은 경우 거리 : -1

        Queue<Integer> q = new ArrayDeque<>();
        dist[X] = 0;
        q.offer(X);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if(dist[v] != -1) continue;
                dist[v] = dist[u] + 1;
                q.offer(v);
            }
        }

        for (int i = 1; i <= N; i++) {
            if(dist[i] == K) sb.append(i).append('\n');
        }
    }
}

