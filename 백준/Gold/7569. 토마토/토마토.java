import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //가로
        int N = Integer.parseInt(st.nextToken()); //세로
        int H = Integer.parseInt(st.nextToken()); //높이

        int[][][] tomatoes = new int[N][M][H]; //0-based
        boolean[][][] visited = new boolean[N][M][H]; //0-based

        Queue<int[]> q = new ArrayDeque<>();

        //모든 토마토가 익어있는 상태 구분
        boolean alreadyRipen = true;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoes[j][k][i] = tomato;
                    if(tomato==0) alreadyRipen = false;
                    if (tomato == 1) {
                        visited[j][k][i] = true;
                        q.offer(new int[]{j, k, i}); //enqueue시 방문처리
                    }
                }
            }
        }

        //저장될 때부터 모든 토마토가 익어있는 상태
        if (alreadyRipen) {
            System.out.println(0);
            return;
        }

        //위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토
        int day = 0;

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        //q-size말고 다른 풀이 있나
        while (!q.isEmpty()) {
            boolean ripen=false;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll(); //tomatoes[N][M][H]
                int x = cur[0], y = cur[1], z = cur[2];
                for (int d = 0; d < 6; d++) {
                    int nx = x + dx[d], ny = y + dy[d], nz = z + dz[d];
                    if(nx<0 ||nx>=N || ny<0 || ny>=M || nz<0||nz>=H) continue;
                    if (visited[nx][ny][nz]) continue;
                    if (tomatoes[nx][ny][nz] == 0) {
                        visited[nx][ny][nz]=true;
                        q.offer(new int[]{nx, ny, nz});
                        tomatoes[nx][ny][nz] = 1;
                        ripen = true;
                    }
                }
            }
            if(ripen) day++;
        }
//        for (int i = 0; i < H; i++) {
//            for (int[][] arr : tomatoes) {
//                for (int[] row : arr) {
//                    for (int val : row) {
//                        System.out.print(val+" ");
//                    }
//                }
//                System.out.println();
//            }
//        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int cur = tomatoes[j][k][i];
                    if (cur == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(day);



    }

}
