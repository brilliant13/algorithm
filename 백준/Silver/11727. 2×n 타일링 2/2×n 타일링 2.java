import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1]; //1~n
        int r = 10007;
        dp[1] = 1;
        if (n >= 2) {
        dp[2] = 3;
        }
        if (n >= 3) {
        dp[3] = 5;
        }
        if (n > 3) {
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1]%r + 2 * dp[i - 2]%r)%r;
        }
        }
        System.out.println(dp[n]);


    }
}