import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;
    static int[] dr = {-1, 1, 0, 0}; //행(row) 변화량(delta)
    static int[] dc = {0, 0, -1, 1}; //열(column) 변화량(delta)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //map이 바뀐다. 테트로미노를 하나 적절히 놓아서 칸에 쓰여 있는 수들의 합을 최대로 하라.
        map = new int[N][M]; //0-based. [0~N-1][0~M-1]
        visited = new boolean[N][M]; //0-based. 0..N-1 : 0,,M-1
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                checkT(i, j); // 'ㅗ' 계열은 연속된 4칸으로 갈 수 없음. 따라서 BruteForce로 직접 구현해주자.
            }
        }
        System.out.print(max);
    }

    static void checkT(int r, int c) {
        // 중심: (r,c)

        // ㅗ : 가운데 + 위 + 왼 + 오른
        //      (r-1, c)
        //(r,c-1) (r,c) (r,c+1)
        if ((r - 1) >= 0 && c - 1 >= 0 && c + 1 < M) {
            int sum = map[r][c] + map[r - 1][c] + map[r][c - 1] + map[r][c + 1];
            max = Math.max(max, sum);
        }
        // ㅜ 모양
        // (r, c-1) (r, c) (r, c+1)
        //   (r+1, c)
        if ((c - 1) >= 0 && (c + 1) < M && (r + 1) < N) {
            int sum = map[r][c] + map[r + 1][c] + map[r][c - 1] + map[r][c + 1];
            max = Math.max(max, sum);
        }
        // ㅓ 모양
        //   (r-1, c)
        // (r, c-1) (r, c)
        //   (r+1, c)
        if ((c - 1) >= 0 && (r - 1) >= 0 && (r + 1) < N) {
            int sum = map[r][c] + map[r - 1][c] + map[r + 1][c] + map[r][c - 1];
            max = Math.max(max, sum);
        }
        // ㅏ 모양
        //   (r-1, c)
        // (r, c) (r, c+1)
        //   (r+1, c)
        if ((r - 1) >= 0 && (r + 1) < N && (c + 1) < M) {
            int sum = map[r][c] + map[r - 1][c] + map[r + 1][c] + map[r][c + 1];
            max = Math.max(max, sum);
        }
    }

    static void dfs(int r, int c, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) continue; //왔던 방향으로는 다시 가지 않음. 같은 칸을 두 번 밟지 않는다.

            visited[nr][nc] = true;
            dfs(nr, nc, depth + 1, sum + map[nr][nc]);
            visited[nr][nc] = false;
        }
    }
}
