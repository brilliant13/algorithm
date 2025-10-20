import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] adj;
    static int[][] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        ans = new int[N][N];

        //인접행렬 채우기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //각 정점 s에서 DFS 한번씩
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N]; //0..N-1 행별 방문기록
            dfs(i,i,visited);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]);
                if(j+1 < N) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    static void dfs(int start, int cur, boolean[] visited) {
        for(int nxt = 0; nxt<N; nxt++){
            if(adj[cur][nxt] == 1 && !visited[nxt]){
                visited[nxt] = true;
                ans[start][nxt] = 1;
                dfs(start,nxt,visited);
            }
        }
    }
}






















