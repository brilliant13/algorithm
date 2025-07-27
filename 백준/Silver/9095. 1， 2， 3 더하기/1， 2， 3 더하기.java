import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int [] dp = new int[11];

    public static void main(String[] args) throws IOException {
        //정수 4를 1,2,3의 합으로 나타내는 방법은 총 7가지이다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int [] dp = new int [11]; //1~10
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]+"\n");
        }
        System.out.print(sb);
    }
}
