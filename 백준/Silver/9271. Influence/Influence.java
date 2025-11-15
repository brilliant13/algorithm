import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    static List<List<Integer>> adj;
//    static boolean[] visited;
//    static int bestMax = -1;
//    static int bestNode = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //n,k 읽기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사회의 개인 숫자
        int k = Integer.parseInt(st.nextToken()); // set X의 요소 숫자

        //집합 X
        List<Integer> setX = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            setX.add(Integer.parseInt(st.nextToken()));
        }

        //그래프, 진입차수
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n + 1]; //진입차수

        //각 사람 줄: u v1 v2 ...
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
                indegree[v]++;
            }
        }

        // 1) Kahn으로 위상정렬 : 진입차수 0 -> Enqueue + 연결된 노드의 진입차수들 -1.  Queue에서 poll()하고 Answer배열(topology)에 추가
        //큐가 빌 때까지 반복한다. -> topology 위상배치 완성
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        List<Integer> topology = new ArrayList<>(n);
        while (!q.isEmpty()) {
            int u = q.poll();
            topology.add(u);
            for (int v : adj.get(u)) {
                if (--indegree[v] == 0) q.offer(v); //진입차수 0이면 topology에 넣어줌.
            }
        }

        // Directed Acyclic Graph가 아니라면(=사이클) topo.size() < n 이지만
        // 문제 조건상 사이클이 없다고 보장된 상황

        // 2) BitSet DP로 reach[u] 계산
        BitSet[] reach = new BitSet[n + 1]; //1..n
        for (int i = 0; i <= n; i++) reach[i] = new BitSet(n + 1);

        // topology를 뒤에서 앞으로. bottom-up DP
        for (int i = topology.size() - 1; i >= 0; i--) {
            int u = topology.get(i);
            for (int v : adj.get(u)) {
                reach[u].set(v); //직접 영향
                reach[u].or(reach[v]);  //v가 영향 주는 사람들
            }
        }

        // 3) 후보 X 중에서 최대 reach size, 동률이면 id 가장 작은 것
        int bestNode = Integer.MAX_VALUE;
        int bestMax = -1;
        for (int x : setX) {
            int cnt = reach[x].cardinality(); //1로 켜진 비트 개수 (집합 크기)
            if (cnt > bestMax || cnt == bestMax && x < bestNode) {
                bestMax = cnt;
                bestNode = x;
            }
        }
        System.out.print(bestNode);
    }


}

