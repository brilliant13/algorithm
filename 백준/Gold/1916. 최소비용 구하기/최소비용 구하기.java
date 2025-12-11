import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge{
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
    static List<Edge>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1<=N<=1,000
        int N = Integer.parseInt(br.readLine());
        // 1<=M<=100,000
        int M = Integer.parseInt(br.readLine());

        //A->B 버스 비용 최소화 목적. 최소비용 구하라. 가중치가 1이면 BFS, 가중치가 1이 아니면 전구간 계속 갱신ㅇ해야 되니까 데이크스트라 알고리즘.
        //vistited[] 대신 dist[]갱신하면서 가는게 dijkstra 알고리즘의 특징

        //인접행렬, 인접리스트

        graph = new ArrayList[N + 1]; //1..N
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight)); //방향 그래프 from -> to (weight)
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        int n = graph.length; //N+1
        dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

//        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.idx;
            int nowDist = cur.dist;

            if(nowDist > dist[now]) continue; //이미 구해놓은 거리보다 크게 나오면 갱신할 필요없음. 패스.

            for (Edge e : graph[now]) {
                int next = e.to;
                int nextDist = nowDist + e.cost; //현재까지의 거리 + 다음 이동거리 => start -> next까지의 거리와 비교
                if (nextDist < dist[next]) {//구해놓은 것보다 작다면 갱신
                    dist[next] = nextDist;
                    pq.offer(new Node(next, nextDist)); // start->next 최소거리가 갱신되었으므로 큐에 넣고,
                    //next와 연결된 Edge들을 모두 다시 확인하면서 업데이트
                }
            }
        }
    }
}
