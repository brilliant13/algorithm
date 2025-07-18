import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 2][M + 2]; //1~(N+1) , 1~(M+1) 2차원 광물배열. 패딩포함
        int max = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 1;
            while (st.hasMoreTokens()) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                j++;
            }
        }
        //이진탐색
        int low = 1;
        int high = max; //2차원 배열에서의 최대 찾으면 됨
        int answer = high;

        while (low <= high) {
            //이진탐색 초기화
            int mid = (low + high) / 2;
            int count = 0;

            if (findMine(mid)) { //K개 이상 뽑으면 채굴기 강도 더 낮춰보기
                answer = mid;
                high = mid - 1;
            } else { //K개 미만 뽑으면, 채굴기 강도 높여보기
                low = mid + 1;

            }
        }
        System.out.println(answer);
    }

    static boolean findMine(int D) {
        boolean[][] visited = new boolean[N + 2][M + 2];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll(); //[0,0]
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //탐색 대상 유무
                if (nx < 0 || ny < 0 || nx >= N + 2 || ny >= M + 2 || visited[nx][ny])
                    continue;
                //채굴
                if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    if (arr[nx][ny] <= D) {
                        count++;
//                        System.err.println("D="+D+" -> mined="+count);
//                        System.err.printf("D=%d mine at (%d,%d) -> count=%d\n", D, nx, ny, count);
                        visited[nx][ny] = true;
                        if (count >= K) return true;
                        q.offer(new int[]{nx, ny});
                    }
                }
                else if( nx==0 ||ny==0 ||ny==M+1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }

            }

        }
        return false;
    }

}
