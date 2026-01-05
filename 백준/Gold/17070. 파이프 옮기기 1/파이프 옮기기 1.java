import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//파이프 옮기기 1
public class Main {
    static final int H =0, V=1, D = 2;
    static int N;
    static int[][] map;
    static long[][][] memo;
    static boolean[][][] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1]; // 1-based
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        memo = new long[N + 1][N + 1][3];
        vis = new boolean[N + 1][N + 1][3];

        //시작: (1,1)-(1,2) 머리=(1,2), 가로
        long ans = dfs(1, 2, H);
        System.out.println(ans);

    }

    static long dfs(int r, int c, int dir) {
        if(r==N && c ==N) return 1; //도착
        if(vis[r][c][dir]) return memo[r][c][dir];
        //방문 안했다면 방문처리
        vis[r][c][dir] = true;

        long res = 0;

        //오른쪽 이동 (H 또는 D에서 가능) -> 다음 dir은 H
        if (dir == H || dir == D) {
            int nc = c + 1;
            if (nc <= N && map[r][nc] == 0) {
                res += dfs(r, nc, H);
            }
        }

        //아래 이동 (V 또는 D에서 가능) -> 다음 dir은 V
        if (dir == V || dir == D) {
            int nr = r+1;
            if (nr <= N && map[nr][c] == 0) {
                res += dfs(nr, c, V);
            }
        }

        //대각 이동 (모든 dir에서 가능) -> 다음 dir은 D
        int nr = r + 1, nc = c + 1;
        if (nr <= N && nc <= N) {
            if (map[r][nc] == 0 && map[nr][c] == 0 && map[nr][nc] == 0) {
                res += dfs(nr, nc, D);
            }
        }

        memo[r][c][dir] = res;
        return res;
    }
}
