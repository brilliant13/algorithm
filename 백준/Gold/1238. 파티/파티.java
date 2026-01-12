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

    static List<Edge>[] graph;
    static int INF = 1_000_000;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //마을 수
        int M = Integer.parseInt(st.nextToken()); //간선 수
        int X = Integer.parseInt(st.nextToken()); //파티열리는 곳

        graph = new ArrayList[N + 1]; //1-based
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //단방향 도로
            graph[u].add(new Edge(v, c));
        }

        //N개의 점 다익스트라 계산
        List<int[]> distDijk = new ArrayList<>();
        distDijk.add(new int[]{0, 0});

        for (int i = 1; i <= N; i++) {
            distDijk.add(dijkstra(i));
        }

        int max = 0;
        int[] xDijk = distDijk.get(X);

        for (int i = 1; i <= N; i++) {
            // i->X
            int[] curDijk = distDijk.get(i);
            int cal1 = curDijk[X];
            //X->i
            int cal2 = xDijk[i];
            max = Math.max(max, cal1 + cal2);
        }
        System.out.print(max);

        //4->2->4 = (10)
//        int[] distA = dijkstra(4);
//        System.out.println(distA[2]);

        //가장 많은 시간을 소비한 학생을 구하라
    }

    static int[] dijkstra(int start) {

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist)); //거리 오름차순 우선순위.
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curIdx = cur.idx;
            int curDist = cur.dist;

            //Stale이면 패스 <이 코드는 현재 뽑은 노드가 갱신대상인지를 따지는 것이다.>
            //현재 그 노드에서의 기록된 최신상태가 맞는지. 구식이면 패스하려는 용도이다. 오름차순 우선순위니까 최신이 나온 뒤는 구식이 기다리고 있다. 그래서 패스용도로 코드작성
            if(dist[curIdx]!=curDist) continue;
            //dist[curIdx] < curDist가 가능한가? dist[]가 업데이트 되면서 Node를 만들고 큐에넣는건데. 불가능하지 않을까?
            //dist[]가 최소여서 갱신되면서 업데이트가 된건데. 그럼 그놈이 최고 우선순위를 가질거고 pop했을 때는 dist[curIdx]랑 같을텐데, 이거 처리되고 같은 노드의 구식이 오면 패스되고.

            //갱신
            dist[curIdx] = curDist;

            //간선타고 체크
            for (Edge edge : graph[curIdx]) {
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
