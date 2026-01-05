import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//파이프 옮기기 1
public class Main {
    static final int H =0, V=1, D = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] map = new int[N + 1][N + 1]; // 1-based
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[N + 1][N + 1][3];
        //파이프의 끝점(머리)를 (r,c)라고 한다.
        dp[1][2][H] = 1; //시작: (1,1)~(1,2), 머리=(1,2), 가로

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if(map[r][c]==1) continue; //벽이면 불가

                //가로 도착: (r,c-1)에서 H 또는 D
                if (c - 1 >= 1) {
                    dp[r][c][H] += dp[r][c - 1][H] + dp[r][c - 1][D];
                }

                //세로 도착: (r-1,c)에서 V 또는 D
                if (r - 1 >= 1) {
                    dp[r][c][V] += dp[r-1][c][V] + dp[r-1][c][D];
                }

                //대각선 도착: (r-1,c-1)에서 H/V/D, 단 3칸이 모두 0
                if (r - 1 >= 1 && c - 1 >= 1) {
                    if(map[r-1][c] == 0 && map[r][c-1] ==0)
                    dp[r][c][D] += dp[r - 1][c - 1][H] + dp[r - 1][c - 1][V] + dp[r - 1][c - 1][D];
                }
            }
        }
        long ans = dp[N][N][H] + dp[N][N][V] + dp[N][N][D];
        System.out.print(ans);
    }

}
