import java.io.*;
import java.util.Arrays;

public class Main {

    static int zero_count ;
    static int one_count ;
    static int[][] memo = new int[41][2];
    static {
        for (int[] row : memo) Arrays.fill(row, -1);
        memo[0][0] = 1; memo[0][1] =0;
        memo[1][0] = 0; memo[1][1] =1;
    }
    static void count(int n) {
        if (memo[n][0] != -1) return;
        count(n-1); count(n-2);
        memo[n][0] = memo[n-1][0] + memo[n-2][0];
        memo[n][1] = memo[n-1][1] + memo[n-2][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Test Case 수
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            count(N);
            sb.append(memo[N][0] + " " + memo[N][1]).append('\n');
        }
        System.out.println(sb);
    }

}
