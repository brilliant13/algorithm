import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]> [] adj;
    static boolean[] visited;
    static int targetDistance;
    static boolean found;

    //DFS(Depth First Search로 두 노드 사이의 거리를 찾아보자
    public static void dfs(int current, int target, int currentDistance) {
        if(found) return;

        if (current == target) {
            targetDistance = currentDistance;
            found = true;
            return;
        }

        visited[current] = true;

        for (int[] edge : adj[current]) {
            int neighbor = edge[0];
            int weight = edge[1];

            if (!visited[neighbor]) {
                dfs(neighbor,target,currentDistance+weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드 개수
        int M = Integer.parseInt(st.nextToken()); // 쿼리 개수

        adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }


        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            //무방향 그래프. 양방향 연결
            addEdge(from, to, weight);
            addEdge(to, from, weight);
        }

        StringBuilder sb = new StringBuilder();
        //M개의 쿼리 처리
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int distance = getDistance(start, end, N);
//            System.out.println(distance);
            sb.append(distance).append('\n');
        }
        System.out.print(sb);

    }

    private static int getDistance(int start, int end, int n) {
        visited = new boolean[n + 1]; // 0~N
        targetDistance = 0;
        found = false;

        dfs(start, end, 0);
        return targetDistance;

    }

    public static void addEdge(int from, int to, int weight) {
        adj[from].add(new int[]{to, weight});
    }

}