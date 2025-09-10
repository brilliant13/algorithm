import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int friends = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < N; i++) {
//            String[] strs = br.readLine().split("");
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
//                char c = strs[j].charAt(0);
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'I') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny]=='X') continue;

                if(map[nx][ny] =='P') friends++;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        System.out.println(friends==0? "TT" : friends);
    }
}
