import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine().trim());

        List<int[]>[] adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // w ∈ [1..10]
            adj[u].add(new int[]{v, w});
        }

        int[] dist = dijkstra(adj, V, K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        }
        System.out.print(sb);
    }

    static int[] dijkstra(List<int[]>[] adj, int V, int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // {node, dist}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            // 이미 더 짧은 거리로 방문된 상태면 스킵
            // 낡은 항목 스킵(이미 더 짧게 갱신된 상태)
            if (d != dist[u]) continue;

            for (int[] e : adj[u]) {
                int v = e[0], w = e[1];
                int nd = d + w;            // w ≤ 10이므로 int 오버플로우 위험 없음
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd}); // 갱신될 때만 push
                }
            }
        }
        return dist;
    }
}
