import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new ArrayDeque<>();
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //가로, 세로, 배추 심어져 있는 위치의 개수
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 1~50
            N = Integer.parseInt(st.nextToken()); // 1~50
            K = Integer.parseInt(st.nextToken()); // 1~2500

            map = new int[M][N];
            visited = new boolean[M][N];

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
                q.add(new int[]{x, y});

            }
//            int A = bfs();
//            System.out.println(A);
            sb.append(bfs()).append('\n');

        }
        System.out.print(sb);
    }

    static int bfs() {
        int countWorm = 0;
        Queue<int[]> inQ = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] Qcur = q.poll();
            int qx = Qcur[0];
            int qy = Qcur[1];
            if(visited[qx][qy]) continue;

            inQ.offer(Qcur);

            while(!inQ.isEmpty()) {
                int[] cur = inQ.poll();
                int curX = cur[0];
                int curY = cur[1];

                if (visited[curX][curY]) continue;
                visited[curX][curY] = true;

                for (int i = 0; i < 4; i++) {
                    int moveX = curX + dx[i];
                    int moveY = curY + dy[i];

                    if (moveX < 0 || moveX > M-1 || moveY < 0 || moveY > N-1) continue;
                    if(visited[moveX][moveY]|| map[moveX][moveY]==0) continue;
                    inQ.offer(new int[]{moveX, moveY});
                }
            }
            countWorm++;
//            System.out.print(countWorm);
        }
        return countWorm;
    }
}
