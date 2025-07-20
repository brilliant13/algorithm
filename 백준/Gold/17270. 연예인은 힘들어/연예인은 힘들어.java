import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프 인접리스트
        List<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 지헌, 성하 출발지에서 각각 모든 정점까지 최단 거리
        int[] distJ = dijkstra(V, graph, J);
        int[] distS = dijkstra(V, graph, S);

        // 1) 최소 합 bestSum 찾기
        int bestSum = INF;
        for (int v = 1; v <= V; v++) {
            if (v == J || v == S) continue;
            int sum = distJ[v] + distS[v];
            if (sum < bestSum) bestSum = sum;
        }
        if (bestSum == INF) {
            System.out.println(-1);
            return;
        }

        // 2) 그 합 중 지헌이 늦지 않고(distJ<=distS), 지헌이 거리 최소 bestJ
        int bestJ = INF;
        for (int v = 1; v <= V; v++) {
            if (v == J || v == S) continue;
            if (distJ[v] + distS[v] != bestSum) continue;
            if (distJ[v] > distS[v]) continue;
            bestJ = Math.min(bestJ, distJ[v]);
        }
        if (bestJ == INF) {
            System.out.println(-1);
            return;
        }

        // 3) 최종 후보 중 번호가 가장 작은 곳 고르기
        int answer = -1;
        for (int v = 1; v <= V; v++) {
            if (v == J || v == S) continue;
            if (distJ[v] + distS[v] != bestSum) continue;
            if (distJ[v] != bestJ) continue;
            if (distJ[v] > distS[v]) continue;
            answer = v;
            break;
        }
        System.out.println(answer);
    }

    // 단일 출발점 다익스트라
    static int[] dijkstra(int V, List<Edge>[] graph, int src) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue;
            for (Edge e : graph[u]) {
                int v = e.to, w = e.w;
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        return dist;
    }
}
