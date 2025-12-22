import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LCS (Longest Common Subsequece
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1]; //dp[i][j] = A[0..i-1], B[0..j-1]

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);//한 글자씩 뺀 바로 직전 두 항의 최대를 그대로 가져온다.누적되니깐.
                }
            }
        }

        System.out.println(dp[n][m]); //무나졍ㄹ 끝까지 체크했을 때 최장 공통 부분수열 길이 알려준다.
    }
}
