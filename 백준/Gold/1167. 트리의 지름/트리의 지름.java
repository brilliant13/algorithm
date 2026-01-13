import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<int[]>[] graph;
    static int V;
    static int farDist;
    static int farNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //트리의 정점의 개수 V
        V = Integer.parseInt(br.readLine());

        graph = new List[V + 1]; // 1-based
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        //간선의 정보
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int n = 0;
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int c = Integer.parseInt(st.nextToken());
                //무방향 그래프
                graph[u].add(new int[]{v, c});
                //문제 조건에서 간선 다 주니까, 역방향 굳이 안 넣어도 된다
//                graph[v].add(new int[]{u, c});
            }
        }


        //트리의 지름이란, 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다.
        //트리의 지름을 구하는 프로그램을 작성하시오

        //최단거리 한 번 찾고. 거기서 다시 최단거리 찾으면 트리의 지름
        dfs(1);

        //임의의 점에서 dfs로 끝 점 찾는다.
        dfs(farNode);
        //그 끝 점에서 dfs로 완전탐색하면서 최장거리 구하면 그게 답이다. (트리의 지름)
        System.out.println(farDist);

    }

    static void dfs(int start) {
        boolean[] visited = new boolean[V + 1]; //1-based O(V)공간. 시간은 초기화 상수취급
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{start, 0});
        visited[start] = true;

        farNode = start;
        farDist = 0;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop(); //정점마다 pop 한 번 // V번
            int x = cur[0];
            int dist = cur[1];

            if (dist > farDist) {
                farDist = dist;
                farNode = x;
            }

            for (int[] edge : graph[x]) { // for는 현재 정점 x의 차수(degree(x))만큼 돈다
                //deg(1)+deg(2)+..+deg(V)
                //모든 정점 차수 합 = 2E = 간선 하나에 양 끝 정점의 차수에 각각 1씩 기여하니까
                //전체차수 2E번 만큼 돈다.
                if (!visited[edge[0]]) {
                    visited[edge[0]]=true;
                    //거리가 누적되어야 되는구나.
                    stack.push(new int[]{edge[0], edge[1]+dist});
                }
            }

            //O(V) + O(2E) = O(V+2E) => O(V+E)
            // 2* O(V+E) => O(V+E)
            //트리라면 E = V-1
            // O(V+E) -> O(2V-1) -> O(2V) -> O(V) = 선형시간
        }
    }
}
