import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1<= n <=1000
        int[] dp = new int[1001]; // 1~1000
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 1001; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1])%10007;
        }
        System.out.println(dp[n]);

    }
}
