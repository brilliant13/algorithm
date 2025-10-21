import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1]; //1-based 1~N
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (dist[s][e] == 0) {
                dist[s][e] = w;
                continue;
            }

            if (dist[s][e] > w) { //갱신
                dist[s][e] = w;
            }
        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                sb.append(dist[i][j]);
//                if(j<n) sb.append(' ');
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);


        //중간점 k ( 1~ N )
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {

                //처음 중간지점이 될 수 있는 곳
                if(dist[i][k]==0) continue;

                for (int j = 1; j <= n; j++) {
                    if (dist[k][j] != 0) {
                        if(i==j) continue;
                        if (dist[i][j] == 0) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        } else {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j]);
                if(j<n) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);


    }
}
