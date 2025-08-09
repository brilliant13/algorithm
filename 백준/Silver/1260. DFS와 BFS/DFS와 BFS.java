import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder answer_dfs = new StringBuilder();
    static StringBuilder answer_bfs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //bfs,dfs 정점 번호가 작은 것 먼저 방문
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N + 1]; //1~N
        for (int i = 0; i <= N; i++) { //1 ~ N
            adj[i] = new ArrayList<>();
        }

        //무방향 그래프
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
        for (int i = 0; i <= N; i++) {
            adj[i].sort(Comparator.naturalOrder());
        }

        boolean[] visited = new boolean[N + 1];
        dfs(adj, visited, V);
        Arrays.fill(visited, false);
        bfs(adj, visited, V);
        System.out.println(answer_dfs);
        System.out.println(answer_bfs);

    }

    static public void dfs(ArrayList<Integer>[] adj, boolean[] visited, int start) {
        //재귀호출
        if (!visited[start]) {
            visited[start] = true;
            answer_dfs.append(start).append(" ");
            if (adj[start].size() == 0) return;
            for (int i = 0; i < adj[start].size(); i++) {
                dfs(adj, visited, adj[start].get(i));
            }
        }
    }

    static public void bfs(ArrayList<Integer>[] adj, boolean[] visited, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            if (visited[v]) continue;
            visited[v] = true;
            answer_bfs.append(v).append(" ");

            for (int i = 0; i < adj[v].size(); i++) {
                if(visited[adj[v].get(i)]) continue;
                q.offer(adj[v].get(i));
//                answer_bfs.append(adj[v].get(i)).append(" ");
            }
        }
    }
}