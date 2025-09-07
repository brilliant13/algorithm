import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1]; //1~n행, 1~m행

        int[][] dist = new int[n + 1][m + 1];
//        Arrays.fill(dist, -1); //-1은 아직 방문 전. 2차원배열이라 스트림을 행하나씩 다시 처리
        Arrays.stream(dist).forEach(row -> Arrays.fill(row,-1));

        //bfs탐색
        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    dist[i][j] = 0;
                } else if (map[i][j] == 2) {
                    q.offer(new int[]{i, j}); //목표지점 offer()
                    dist[i][j] = 0;
                }
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                System.out.print(dist[i][j]+" ");
//            }
//            System.out.println();
//        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx<1 || nx>n || ny<1 || ny>m) continue;
                if (map[nx][ny] == 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }

    }
}
