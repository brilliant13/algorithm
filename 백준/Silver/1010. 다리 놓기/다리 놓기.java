import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] C = new int[30][30]; // M, N < 30
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 조합 DP 테이블 미리 채우기
        buildComb();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            // 다리 놓는 경우의 수 = M C N
            sb.append(C[M][N]).append('\n');
        }
        System.out.print(sb);
    }

    static void buildComb() {
        for (int n = 0; n < 30; n++) {
            C[n][0] = 1;
            C[n][n] = 1;
            for (int r = 1; r < n; r++) {
                C[n][r] = C[n - 1][r - 1] + C[n - 1][r];
            }
        }
    }
}
