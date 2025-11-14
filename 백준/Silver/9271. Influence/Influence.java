import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int bestMax = -1;
    static int bestNode = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n과 k 입력
        int n = Integer.parseInt(st.nextToken()); // 사회의 개인 숫자
        int k = Integer.parseInt(st.nextToken()); // set X의 요소 숫자

        //집합 X 입력
        List<Integer> setX = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            setX.add(Integer.parseInt(st.nextToken()));
        }

        //간선 입력
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); //1-based. 1~n 리스트
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                adj.get(u).add(v);
            }
        }
        //각 후보마다 영향력 계산
        for (int candidate : setX) {
            visited = new boolean[n + 1];
            int count = dfs(candidate) - 1; //자기 자신 제외

//            System.out.println("후보 " + candidate + ": " + count + "명");

            //influence가 더 크다 or influence는 같고 identifier가 작으면 갱신
            if (count > bestMax || (count == bestMax && candidate < bestNode)) {
                bestMax = count;
                bestNode = candidate;
            }
        }
        System.out.println(bestNode);
    }

    static int dfs(int node) {
        visited[node] = true;
        int count = 1; //현재 노드 카운트

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                count += dfs(next); //재귀로 누적
            }
        }

        return count;
    }
//    static void dfs(int startNode, int curNode) {
//        if (adj.get(curNode).isEmpty()) {
//            if (localMax >= bestMax) {
//                bestMax = localMax;
//                bestNode = startNode;
//                System.out.println("bestMax = " + bestMax);
//                System.out.println("bestNode = " + bestNode);
//            }
//            return;
//        }
//
//        for (int nxt : adj.get(curNode)) {
//            localMax++;
//            dfs(startNode, nxt);
////            System.out.println("localMax = " + localMax);
//            localMax--;
//        }
//
//    }
}

