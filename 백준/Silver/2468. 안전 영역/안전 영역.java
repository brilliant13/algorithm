import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    static int[][] map;
    static boolean[][] visited;
    static int bestArea = 0;
    static int curArea = 0;

    public static void main(String[] args) throws IOException {
        //재난방재청에는 많은 비가 내리는 장마철에 대비하여 다음과 같은 일을 계획하고 있다.
        //먼저 어떤 지역의 높이 정보를 파악한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //DFS,BFS가 100번 돈다면
        //격자수 최대 10,000개. 빅오 최대 백만번연산.
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        StringTokenizer st;
        int maxHeight = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int curH = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, curH);
                map[i][j] = curH;
            }
        }
//        for (int[] ints : map) {
//            for (int anInt : ints) {
//                System.out.print(anInt+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("최대 높이는 = "+maxHeight);

        for (int h = 0; h <= maxHeight; h++) {
            //높이의 후보는 1~maxHeight
            //높이 갱신시마다 방문 초기화
            for (boolean[] vis : visited) {
                Arrays.fill(vis, false);
            }
            curArea = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visited[i][j] && map[i][j] > h) {

                        visited[i][j] = true;
                        //bfs한번돌면 쭉 다 퍼지니까. 그게 하나의 영역이된다. count++
                        curArea++;
                        bfs(i, j, h);
                    }
                }
            }
            bestArea = Math.max(bestArea, curArea);
        }
        System.out.println(bestArea == 0 ? 0 : bestArea);
    }

    static void bfs(int row, int col, int rainHeight) {
        //rainHeight 이하의 곳은 모두 물에 잠긴다
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});

         while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
                    if (!visited[nx][ny] && map[nx][ny]>rainHeight) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
