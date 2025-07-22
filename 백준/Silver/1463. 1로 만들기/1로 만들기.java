import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0 ; //1은 1이니까 연산 0번이다.

        //상향식으로 가자. Bottom-Top 아래에서부터 위로 채워나간다. vs 하향식. Top-bottom. 재귀로 불러가면서 위에서부터 채울 수도 있음.
        //최적부분구조. 큰 문제의 최적해가 작은 문제의 최적해로 구성될 수 있다. 조합가능. 10-9-3-1일 때 10의 최적해는 9의최적해 + 1이다.
        for (int i = 2; i <= N; i++) {
            //기본 연산: 1을 빼는 경우
            dp[i] = dp[i-1] +1;

            //2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }

            //3으로 나누어 떨어지느 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[N]);

    }
}
