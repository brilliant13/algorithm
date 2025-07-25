import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][]colors = new int[N+1][3];// 1~N까지의 집.  r:0, g:1, b:2
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }
        //메모이제이션
        int[][]dp = new int[N+1][3];
        dp[1][0] = colors[1][0];
        dp[1][1] = colors[1][1];
        dp[1][2] = colors[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = colors[i][0]+Math.min( dp[i-1][1],dp[i-1][2]);
            dp[i][1] = colors[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = colors[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        //3N번연산
        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));


    }


}
