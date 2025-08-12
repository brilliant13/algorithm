import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 10007;

        final int r = 10007;
        if(n==1){
            System.out.println(1); return;
        }
        int[] dp = new int[n + 1]; //1~n
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2])%MOD;
        }
        System.out.println(dp[n]);


    }
}