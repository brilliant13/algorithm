import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node {
        int idx;
        int dist;

        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static final int INF = 1_000_000_000;
    static int N;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        //방향성이 없는 그래프
        //특정한 최단 경로. 임의의 두 정점은 반드시 통과해야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //1 -> N  최단 경로
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new List[N + 1]; //1-based
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            //방향성이 없는 그래프
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstraAll(1);
        int[] distV1 = dijkstraAll(v1);
        int[] distV2 = dijkstraAll(v2);

        int cand1 = INF;
        if (dist1[v1] < INF && distV1[v2] < INF && distV2[N] < INF) {
            cand1 = dist1[v1] + distV1[v2] + distV2[N];
        }

        int cand2 = INF;
        if (dist1[v2] < INF && distV2[v1] < INF && distV1[N] < INF) {
            cand2 = dist1[v2] + distV2[v1] + distV1[N];
        }

        int ans = Math.min(cand1, cand2);
        System.out.print(ans >= INF ? -1 : ans);



    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N+1];// 1-based. 1~800
        Arrays.fill(dist, INF);

        dist[start]=0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.idx, curDist = cur.dist;

            if(curDist > dist[curIdx]) continue;
            dist[curIdx] = curDist;

            for (Edge edge : graph[curIdx]) {
                int nxt = edge.to;
                int nxtDist = curDist+ edge.cost;
                if (nxtDist < dist[nxt]) {
                    dist[nxt] = nxtDist;
                    pq.offer(new Node(nxt, dist[nxt]));
                }
            }
        }
        return dist[end];
    }
    static int[] dijkstraAll(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.idx;
            int d = cur.dist;

            if(d!=dist[u]) continue; //dist오름차순 우선순위로 뽑으니까 뒤에오는 것들은 거리가 더 크니까, 같지 않으면 패스.

            for (Edge e : graph[u]) {
                int v = e.to;
                int nd = d + e.cost;
                if (nd < dist[v]) {
                    //거리를 업데이트하고 그 후에 큐에 Node생성해서 넣네.
                    //거리가 갱신되었으니 그 후보를 넣는거네. 그리고 그 노드 확장해서 주변 검사하고
                    dist[v] = nd;
                    //출발점 -> v 가 갱신되었다.
                    //노드 v를 우선순위 큐에 넣고, 그것과 연결된 간선들을 다시 살펴보자.
                    pq.offer(new Node(v, nd));
                }
            }
        }
        return dist;
    }
}
