import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            this.to=to;
            this.cost = cost;
        }
    }

    static int N;
    static int INF = 1_000_000_000;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 1 -> V1 -> V2 -> N
        // 1 -> V2 -> V1 -> N
        // -1 (경로 없음)

        //최단거리가 존재한다면, 각 3구간에서도 최단거리여야 한다.
        //dijkstra(1), dijkstra(V1), dijkstra(V2)
        //배열로 받아서 끝 점까지의 거리 봐도 되고, 끝점 매개변수로 받아서 return하게 해도 되고
        //배열로 받는게 1->V1, 1->V2 한 번에 보기 좋겠다. 함수 한 번 호출로.
        //dijkstra(1,V1), dijkstra(1,V2) ...

       //Graph 인접리스트 정의
        graph = new List[N + 1]; //1-based
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        //간선 입력 (무방향 그래프)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, c));
            graph[v].add(new Edge(u, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //다익스트라 구현
        //1->V1->V2->N   or 1->V2->V1->N
        int[] dist = dijkstra(1); //1을 시작점으로하는 다익스트라
        int[] v1Dist = dijkstra(v1); //v1을 시작점으로하는 다익스트라
        int[] v2Dist = dijkstra(v2); //v2를 시작점으로하는 다익스트라

        //시작점에서 간선을 타고 가는데도 도달이 안되면 dist[x] =INF이다.
        int ans;
        int route1 = INF;
        int route2 = INF;

        //1->V1->V2->N 경로가 존재한다면
        if (dist[v1] != INF && v1Dist[v2] != INF && v2Dist[N] != INF) {
            route1 = dist[v1] + v1Dist[v2] + v2Dist[N];
//            System.out.println(route1);
        }
        //1->V2->V1->N 경로가 존재한다면
        if (dist[v2] != INF && v2Dist[v1] != INF && v1Dist[N] != INF) {
            route2 = dist[v2] + v2Dist[v1] + v1Dist[N];
//            System.out.println("route2 = " + route2);
        }
        ans = Math.min(route1, route2);
//        System.out.println("ans = " + ans);

        System.out.print(ans == INF ? -1 : ans);

    }

    static int[] dijkstra(int start) {
        //채워야하는 다익스트라 거리배열
        int[] dist = new int[N + 1]; //1-based. 1..N
        Arrays.fill(dist, INF);

        //시작점 처리
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));//오름차순 우선순위
        //갱신 대상으로 올라오면 Node만들어서 우선순위 큐에 넣어준다.
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            //갱신 대상 꺼냈으면 그 노드로부터 간선타고 확장해서 거리들 갱신되는지 확인해본다.
            int nowIdx = now.idx;
            int nowDist = now.dist;

            //dist[]는 계속 작은 수 우선순위로 업데이트되면서 갱신중이다. 같지않으면 큰 상태인데. 큰 상태는 Stale한 상태이므로 패스한다.
            //내가 지금 now 노드를 갱신해도 되겠는지 판단하는 것이니, 당연히 dist[]최신값이랑 같아야 한다. Stale한 건 볼 필요가 없다. 이미 거리가 더 작은 노드를 앞에서 처리했으니, 큰 노드는 볼 필요가 없다.
            //예를 들어 앞에 있는 노드를 처리해서 dist[A]=10 ->3으로 바뀌었는데, 큐에 남아있던 A(10)노드를 poll()한다면,
            //현재 10노도는 dist[10]=3으로 최신상태인데, nowDist(start->10)는 10으로 구식의(Stale,신선하지않은)상태이다.
            //그러므로 nowDist > dist[nowIdx]가 되므로 볼 필요가 없는 것이다.
            //애초에 nowDist < dist[nowIdx]는 나올 수가 없다. dist[]가 갱신될 때는 그 갱신시킨 Node를 반드시 큐에 넣는다.
            //같은 idx에 노드가 큐에있다고해도 그 갱신된 dist가 가장 작을 것이기 때문에 먼저 pop된다.
            //nowDist == dist[nowIdx]가 된다.
            //같은 idx에 노드가 큐에 있을 때 dist가 더 큰 놈이 pop되어야 nowDist
            //dist[x]가 업데이트 될 때, 그 업데이트 시킨 x노드가 반드시 큐에 들어간다.
            //그럼 반드시 그 x노드들중에 dist가 최소인게 먼저 pop된다.
            //그 x노드들 중에 dist가 최신 갱신된 것보다 더 최소인게 pop되어야
            // nowDist < dist[nowIdx]가 성립하는데 그럴 수 없다.
            //dist가 최신 갱신된 것보다 더 최소인게 큐에 있으려면, 최신 갱신된 게 그 최소거리를 갖는 노드였어야 하므로 모순이다.
            //정리하자면, dist[]는 항상 그 턴에서 최신상태를 유지하므로,
            //우선순위큐에서 노드를 pop할 때 nowDist == dist[nowIdx](최신상태에 반영된 노드니 확장 갱신 대상)이거나
            //nowDist > dist[nowIdx](구식 상태의 노드니 확장 갱신 대상이 아니다.)인 상황만 발생한다.
            //그래서 조건을 !=로 해도 된다.
            if(nowDist != dist[nowIdx]) continue;
            //dist[A]가 INF -> 10 -> 1로 바뀌는 모습 상상

            //갱신 대상 노드의 간선을 타고 확장 탐색
            for (Edge edge : graph[nowIdx]) {
                int next = edge.to;
                //Start -> next : 시작점으로부터 next노드까지의 거리
                int nextDist = nowDist + edge.cost;
                if (nextDist < dist[next]) { //갱신 후보의 거리가 기존에 계산되어 있던 start->next보다 작다면 최소거리이므로 갱신한다.
                    dist[next] = nextDist;
                    //갱신되었으므로, 갱신 대상 Node를 만들어서 우선순위 큐에 넣어준다.
                    pq.offer(new Node(next, nextDist));
                }
            }
        }
        return dist;
    }
}
