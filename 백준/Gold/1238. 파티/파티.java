import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//파티
public class Main {

    static class Node {
        int idx;
        int dist;

        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Edge>[] graph;     // 원그래프
    static List<Edge>[] revGraph;  // 역그래프
    static int INF = 1_000_000_000;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //마을 수
        int M = Integer.parseInt(st.nextToken()); //간선 수
        int X = Integer.parseInt(st.nextToken()); //파티열리는 곳

        graph = new ArrayList[N + 1]; //1-based
        revGraph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //단방향 도로
            graph[u].add(new Edge(v, c)); // u -> v

            revGraph[v].add(new Edge(u, c));   // 역방향: v -> u
        }

        // X -> i 최단거리 (원그래프)
        int[] distFromX = dijkstra(X, graph);
        // i -> X 최단거리 (역그래프에서 X -> i 로 계산)
        //이 트릭이 핵심. dist[]를 구해놓고 한방에 끝낸다.
        //dijkstra를 N번 반복칠 필요가 없네.
        int[] distToX = dijkstra(X, revGraph);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, distToX[i] + distFromX[i]);
        }
        System.out.print(max);

    }

    static int[] dijkstra(int start, List<Edge>[] g) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist)); //거리 오름차순 우선순위.
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.idx;
            int curDist = cur.dist;

            // stale skip
            if(dist[curIdx]!=curDist) continue;

            //간선타고 체크
            for (Edge edge : g[curIdx]) {
                int nextIdx = edge.to;
                int nextDist = curDist + edge.cost;
                if (nextDist < dist[nextIdx]) {
                    dist[nextIdx] = nextDist;
                    pq.offer(new Node(nextIdx, nextDist));
                }
            }
        }
        return dist;
    }
}
