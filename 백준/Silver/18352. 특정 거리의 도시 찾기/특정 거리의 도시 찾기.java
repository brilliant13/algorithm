import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to;
        int w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class Node {
        int v;
        long d;                         // 거리 overflow 방지용 long

        Node(int v, long d) {
            this.v = v;
            this.d = d;
        }
    }

    static final long INF = (long) 1e18;

    static long[] dijkstra(int n, int start, List<List<Edge>> g, int[] prev) {
        //dist[i]는 시작점 start->i 까지 가능 경로를 계속 업데이트해가면서 최단거리를 남긴다.
        //prev[i]는 start->i의 경로를 결정할 때 그 직전의 노드번호를 기록한다. 즉, 최단경로가 갱신되는 그 시점에서 직전에 타고 들어온 노드번호를 기록하는 것이다.
        //이 prev[]를 역추적 해나가면 경로를 구해낼 수 있다.

        long[] dist = new long[n + 1]; // 1..N
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.d));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.d != dist[cur.v]) continue; //stale 제거
            for (Edge e : g.get(cur.v)) {
                long nd = cur.d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    prev[e.to] = cur.v;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        return dist;
    }

    // prev[]로 s->t 경로 복원
    static List<Integer> buildPath(int[] prev, int s, int t) {
        LinkedList<Integer> path = new LinkedList<>();
        //prev[t]라는건 갱신이 안 되었다는 말. dist[t]가 갱신될 때 t로 가는 직전에 타고간 노드번호를 prev[t]에 기록하는데,
        //-1이라는 건 초기값 그대로니 dist[t]가 갱신이 안되어서 INF상태.
        if (prev[t] == -1 && s != t) return path; //경로 없음
        for (int v = t; v != -1; v = prev[v]) {
            path.addFirst(v);
        }
        return path;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 예: N M / 다음 M줄: u v w / 시작 S
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        //인접 리스트 : List<Edge> [] g = new ArrayList[N+1];로 구현해도 되긴함. g[0~N] = new ArrayList<>();로 초기화는 똑같이 필수.
        List<List<Edge>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) g.add(new ArrayList<>()); // index 0..N

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            //간선들을 저장
            g.get(u).add(new Edge(v, 1));
            //무방향이면 g.get(v).add(new Edge(u,w));
        }
        int[] prev = new int[N + 1];
        long[] dist = dijkstra(N, X, g, prev);

        //예시 출력 : S에서 각 정점까지 거리
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <= N; v++) {
            if (dist[v] == K) {
                sb.append(v).append('\n');
            }
//            sb.append(dist[v] >= INF / 2 ? "INF" : dist[v]).append('\n');
        }
        if (sb.toString().equals("")) {
            System.out.print(-1);
            return;
        }
        System.out.print(sb);
    }
}

