import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        map = new int[N + 1][M + 1]; //1-based
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        dist = new int[N+1][M+1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        System.out.print(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 1, 0}); //x,y,breakUsed
        dist[1][1][0] = 1; //시작 칸 포함

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], b = cur[2];

            if(x==N && y ==M) return dist[x][y][b];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if(nx<=0 || nx>N || ny<=0 || ny>M) continue;

                //빈칸
                if (map[nx][ny] == 0) {
                    if (dist[nx][ny][b] == -1) {
                        dist[nx][ny][b] = dist[x][y][b] + 1;
                        q.offer(new int[]{nx, ny, b});
                    }
                }
                //벽
                else {
                    if (b == 0 && dist[nx][ny][1] == -1) {
                        dist[nx][ny][1] = dist[x][y][b] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }
            }
        }
        return -1;
    }
}
