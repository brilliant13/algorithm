import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N + 1][M + 1]; // 1~N, 1~M
        int[][] map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }
        System.out.println(bfs(map, N, M));

    }

    static int bfs(int[][] map, int N, int M) {
        boolean[][] visited = new boolean[N + 1][M + 1];
        int[][] dist = new int[N + 1][M + 1];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});
        visited[1][1] = true;
        dist[1][1] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if(x == N && y == M) return dist[x][y]; // 최단거리

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                //1-based 경계
                if(nx<1 || nx>N || ny<1 || ny>M) continue;
                if(map[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                q.add(new int[]{nx, ny}); //enqueue시 방문처리
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;// 이전꺼에서 한 칸 추가하는 것이다. 칸별 거리 갱신
            }
        }
        return -1; //형식 맞추기용. 문제조건에서는 여기 도달 안함. 무조건 (N,M)을 찾을 수 있게 입력이 주어짐
    }
}
