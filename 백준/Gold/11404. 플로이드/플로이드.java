import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1]; //1-based 1~N

        //초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; //자기 자신은 0 (문제 출력 형식과 일치)
        }

        //간선 입력 : 최소 비용 유지
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[s][e] = Math.min(dist[s][e], w);
        }

        //중간점 k ( 1~ N )
        //Floyd-Warshall
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                //처음 중간지점이 될 수 있는 곳
                if (dist[i][k] == INF) continue;
                for (int j = 1; j <= n; j++) {
                    if (dist[k][j] == INF) continue;
                    int cand = dist[i][k] + dist[k][j];
                    if (cand < dist[i][j]) dist[i][j] = cand;
                }
            }
        }

        //출력: 도달 불가면 0, 아니면 최솟값
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j]==INF ? 0 : dist[i][j]);
                if (j < n) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);


    }
}
