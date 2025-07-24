import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> [] adj;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        adj = new ArrayList[computer + 1]; // 1~computer
        for (int i = 0; i <= computer; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[computer + 1];

        StringTokenizer st;
        for (int i = 1; i <= edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            //노드 추가 틀렸네. 무방향그래프니까 양쪽에 해줘야지
//            adj[i].add(new int[]{from, to});
            adj[from].add(new int[]{from, to});
            adj[to].add(new int[]{to,from});
        }

        dfs(1);
        System.out.println(count);
    }

    static void dfs(int start) {

        if(visited[start]) return;

        visited[start]=true;
//        count++;

        for (int i = 0; i < adj[start].size(); i++) {
            if(visited[adj[start].get(i)[1]]) continue;

            //다른 곳으로 번질 때마다 + 1
            count++;
            dfs(adj[start].get(i)[1]);

        }
    }


}
