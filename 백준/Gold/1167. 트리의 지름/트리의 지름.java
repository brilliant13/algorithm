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
                graph[v].add(new int[]{u, c});
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
        boolean[] visited = new boolean[V + 1]; //1-based
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{start, 0});
        visited[start] = true;

        farNode = start;
        farDist = 0;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int x = cur[0];
            int dist = cur[1];

            if (dist > farDist) {
                farDist = dist;
                farNode = x;
            }

            for (int[] edge : graph[x]) {
                if (!visited[edge[0]]) {
                    visited[edge[0]]=true;
                    //거리가 누적되어야 되는구나.
                    stack.push(new int[]{edge[0], edge[1]+dist});
                }
            }
        }
    }
}
