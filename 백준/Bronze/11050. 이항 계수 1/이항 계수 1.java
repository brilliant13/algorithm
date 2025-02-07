import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        dp = new int[n+1][r+1];

        System.out.println(BC(n, r));


    }

    static int BC(int n, int r) {
        if(dp[n][r]>0) return dp[n][r];
        if (n == r || r == 0) {
           return dp[n][r] = 1;
        } else {
            return dp[n][r] = BC(n - 1, r - 1) + BC(n - 1, r);
        }
    }
}