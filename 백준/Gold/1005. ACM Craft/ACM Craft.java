import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            //건물 개수(노드 수) N,  (2<= N <=1000)
            int N = Integer.parseInt(st.nextToken());
            //건물순서 규칙 개수(간선의 수) K, (1<=K <=100,000)
            int K = Integer.parseInt(st.nextToken());

            //걸리는 시간 비용 저장
            int[] cost = new int[N + 1]; //1-based. 1..N
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] adj = new ArrayList[N + 1]; // 1-based. 1..N
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }
            //위상정렬용 진입차수 Indegree
            int[] indegree = new int[N + 1]; // 1..N

            //건물 순서 입력(그래프 간선 입력) : 규칙 u를 지은 후에 v를 지을 수 있다. (u -> v)
            //방향 비순환 그래프. DAG
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                indegree[v]++;
            }

            //건설해야할 건물의 번호
            int W = Integer.parseInt(br.readLine());

            //dp[i] = i번 건물을 완성하는데 걸리는 최소 시간
            int[] dp = new int[N + 1];
            // 일단은 자기 건설 시간으로 초기화
            for (int i = 1; i <= N; i++) {
                dp[i] = cost[i];
            }

            //위상정렬 (Kahn)
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll(); //큐에서 뽑히는 순으로 그 자체가 위상정렬이다. 모든 간선의 선행 조건을 고려한 순서.

                for (int v : adj[u]) {
                    //v를 짓기 위해서는 u가 먼저 끝나야 하므로
                    //v의 완료 시간 후보 = u가 끝난 시간 + v 자신 짓는 시간
                    //dp[v]는 이미 cost[v]를 포함하므로
                    //dp[v] = max(dp[v], dp[u] + cost[v])와 같음
                    dp[v] = Math.max(dp[v], dp[u] + cost[v]);

                    if (--indegree[v] == 0) {
                        q.offer(v);
                    }
                }
            }
            sb.append(dp[W] + "\n");
        }
        System.out.print(sb);
    }


}

