import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //2:38
        //적록색약 : R,G 같다.
        //구역은 같은색. 상하좌우로 인접해있응면 두 글자는 같은 구역
        //(색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //BFS. 큐를 활용. 현재 자리랑 같으면 지속. 더 갈때없으면 종료. 더이상 못퍼지면 그게 카운트 1
        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                //방문하지 않았으면
                bfs(map, new int[]{i, j}, visited);
                count++;
            }
        }
//        System.out.println(count);
        sb.append(count).append(' ');
        for (boolean[] vis : visited) {
            Arrays.fill(vis, false);
        }
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                //방문하지 않았으면
                bfs_blindness(map, new int[]{i, j}, visited);
                count++;
            }
        }
//        System.out.println(count);
        sb.append(count);
        System.out.print(sb);
    }

    static void bfs(char[][] map, int[] cur, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cur[0]][cur[1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int posX = pos[0], posY = pos[1];
            char curChar = map[posX][posY];
            for (int i = 0; i < 4; i++) {
                int x = posX + dx[i], y = posY + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (visited[x][y]) continue;
                if (map[x][y] == curChar) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    static void bfs_blindness(char[][] map, int[] cur, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(cur);
        visited[cur[0]][cur[1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int posX = pos[0], posY = pos[1];
            char curChar = map[posX][posY];
            for (int i = 0; i < 4; i++) {
                int x = posX + dx[i], y = posY + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= N) continue;
                if (visited[x][y]) continue;
                if (curChar == 'B' && map[x][y] == curChar) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                } else if ((curChar == 'R' || curChar == 'G') && map[x][y] != 'B'){
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}

