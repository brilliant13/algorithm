import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[][] tomatoes;
    static boolean[][] visited;
    static int days = 0;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 1;
            while (st.hasMoreTokens()) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
                j++;
            }
        }

        //토마토판 출력
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//                System.out.print(tomatoes[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(day_bfs());


    }

    static int day_bfs() {
        if (queue.isEmpty()) return -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyRipened = false;

            for (int k = 0; k < size; k++) {
                int[] arr = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x_dx = arr[0] + dx[i];
                    int y_dy = arr[1] + dy[i];
                    if (x_dx < 1 || x_dx > N || y_dy < 1 || y_dy > M) continue;

                    if (visited[x_dx][y_dy]) continue;
                    visited[x_dx][y_dy] = true;

                    if (tomatoes[x_dx][y_dy] == -1) continue;
                    if (tomatoes[x_dx][y_dy] == 0) {
                        tomatoes[x_dx][y_dy] = 1;
                        queue.offer(new int[]{x_dx, y_dy});
                        anyRipened = true;
                    }
                }
            }
            if (anyRipened) days++;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (tomatoes[i][j] == 0) return -1;
            }
        }
        return days;
    }
}
