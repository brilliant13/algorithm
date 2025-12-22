import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//LCS (Longest Common Subsequece
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1]; //dp[i][j] = A[0..i-1], B[0..j-1]

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);//한 글자씩 뺀 바로 직전 두 항의 최대를 그대로 가져온다.누적되니깐.
                }
            }
        }
        sb.append(dp[n][m]).append('\n');
        if (dp[n][m] == 0) {
            System.out.println(sb);
            return;
        }

        //역추적

        //직전 문자열 두 개와 개수가 같은 경우는, 같은 곳 중 아무 곳으로 이동. 현재 순서에서 공통문자열 없었응니까 이전 항까지의 최대공통수열 갯수 가져온 거니까

        //직전 문자열 두 개 중 같은 숫자가 없을 떈, dp[i-1][j-1] 양쪽에서 한 개씩 뺀 문자열에서 +1해서 넘어온 거 = 즉, 현재차례에 동일 문자열 있다는 말
        //그럼 그 문자열 result에 저장하고 [i-1][j-1]로 이동

        int i = n;
        int j = m;
        List<Character> result = new ArrayList<>();
        StringBuilder lcs = new StringBuilder();
        while (i>0 && j>0) {
            int cur = dp[i][j];
            int diag1 = dp[i][j - 1];
            int diag2 = dp[i - 1][j];

            if (cur == diag1) {
                j = j - 1;
                continue;
            } else if (cur == diag2) {
                i = i - 1;
                continue;
            } else {
                result.add(A.charAt(i - 1));
                lcs.append(A.charAt(i - 1));
                i = i - 1;
                j = j - 1;
            }
            if (i == 0 || j == 0) break;

        }
        //result 역순
//        for (int k = result.size() - 1; k >= 0; k--) {
//            sb.append(result.get(k));
//        }
        sb.append(lcs.reverse());

        System.out.println(sb);

    }
}
