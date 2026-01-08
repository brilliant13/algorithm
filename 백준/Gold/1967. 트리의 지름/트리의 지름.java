import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int to,w;
        Edge(int to, int w) {
            this.to =to;
            this.w = w;
        }
    }

    static int n;
    static List<Edge>[] graph;

    static int farNode;
    static int farDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];//1-based
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        //1) 임의의 노드(1)에서 가장 먼 노드 A 찾기 (트리의 지름 위의 끝 점 후보는 A,B이다.)
        dfsIter(1);
        int A = farNode;
        
        //2) A에서 가장 먼 노드까지 거리 = 지름
        //트리 지름 위에 있는 끝 점(끝 리프 노드)중의 하나인 A를 발견했다.
        //A에서 최대거리에 있는 B가 바로 트리의 지름이다. B는 트리 지름 위에 있는 끝 점(끝 리프 노드)이다.
        dfsIter(A);
        System.out.print(farDist);
    }

    static void dfsIter(int start) {
        boolean[] vis = new boolean[n + 1];//1..n
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{start, 0});
        vis[start] = true;

        farNode = start;
        farDist = 0;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int x = cur[0], dist = cur[1];

            if (dist > farDist) {
                farDist = dist;
                farNode = x;
            }

            for (Edge edge : graph[x]) {
                if (!vis[edge.to]) {
                    vis[edge.to] = true;
                    stack.push(new int[]{edge.to, dist + edge.w});
                }
            }
        }
    }
}
