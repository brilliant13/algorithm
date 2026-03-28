import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1]; // 1-based
        int[][] D = new int[N + 1][N + 1]; // 1-based

        for (int i = 1; i <= N; i++) {// O(N^2)
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간 합 배열 채우기(만들기). "(0,0) ~ (i,j)까지의 구간 합을 저장하는 합 배열"
        for (int i = 1; i <= N; i++) {// O(N^2)
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(prefixSum(x1, y1, x2, y2, D));
            if (i < M - 1) sb.append('\n');
        }

        System.out.print(sb);
    }

    static int prefixSum(int x1, int y1, int x2, int y2, int[][] D) {// O(1)
        // 만든 구간 합 배열을 이용해서, "(x1,y1) ~ (x2, y2)" 구간 합을 구하는 쿼리를 처리하자.
        return D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1];

    }
}

