import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        int[][] g = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Warshall: 경로 존재 여부 전파
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (g[i][k] == 0) continue; // 미세 최적화
                for (int j = 0; j < N; j++) {
                    if (g[k][j] == 1) g[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(g[i][j]);
                if (j + 1 < N) sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
