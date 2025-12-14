import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tri = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DP
        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) { //왼쪽 끝
                    dp[i][j] = dp[i - 1][0] + tri[i][j];
                } else if (j == i) { //오른쪽 끝
                    dp[i][j] = dp[i - 1][i - 1] + tri[i][j];
                } else { //중간
                    dp[i][j] = tri[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        System.out.print(ans);

    }
}
