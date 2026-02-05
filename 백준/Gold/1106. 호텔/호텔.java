import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //돈의 최솟값을 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //고객을 적어도 C명 늘여야 한다.
        int C = Integer.parseInt(st.nextToken());
        //도시의 개수는 N개
        int N = Integer.parseInt(st.nextToken());
        //적어도 C명 늘이기 위해 투자해야하는 돈의 최솟값을 구하라.

        int[][] info = new int[N][2];
        final int INF = 1_000_000_000;

        int maxGain =0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int gain = Integer.parseInt(st.nextToken());
            info[i][0] = cost;
            info[i][1] = gain;
            maxGain = Math.max(maxGain, gain);
        }
        //int limit = N + maxGain;
        int limit = C + maxGain;
        int[] dp = new int[limit+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int k = 0; k < N; k++) {
            int cost = info[k][0];
            int gain = info[k][1];
            for (int i = gain; i <= limit; i++) {
                //현재 (cost,gain)을 택하기 직전의 상태를 본다. dp[i-gain]
                //부분 최적 구조이기 때문에 dp[i-gain]도 인원수=(i-gain)될때까지의 최적구조이다.
                //부분해가 합쳐져서 전체 해가 된다. 이것이 DP
                if (dp[i - gain] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - gain] + cost);
                }
            }
        }
        int ans = INF;
//        for (int i = N; i <= limit; i++) {
        for (int i = C; i <= limit; i++) {
//            System.out.println("dp = " + dp[i]);
            ans = Math.min(ans, dp[i]);
        }
        System.out.print(ans);




    }
}
