import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n]; //0-based
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n];

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            if (n == 1) {
                sb.append(Math.max(dp[0][0], dp[1][0])).append('\n');
                continue;
            }
            dp[0][1] = dp[1][0] + stickers[0][1];
            dp[1][1] = dp[0][0]+ stickers[1][1];

            if (n == 2) {
                sb.append(Math.max(dp[0][1], dp[1][1])).append('\n');
                continue;
            }



            for (int k = 2; k < n; k++) {
                dp[0][k] = stickers[0][k] + Math.max(dp[1][k - 1], dp[1][k - 2]);
                dp[1][k] = stickers[1][k] + Math.max(dp[0][k - 1], dp[0][k - 2]);
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append('\n');
        }
        System.out.print(sb);
    }
}
