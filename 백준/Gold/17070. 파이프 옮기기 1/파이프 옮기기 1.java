import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//파이프 옮기기 1
public class Main {
    static int count = 0;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N + 1][N + 1]; // 1-based
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] before = {1, 1};
        int[] current = {1, 2};
        dfs(before, current);
        System.out.print(count);
    }

    static void dfs(int[] before, int[] current) {

        if (Arrays.equals(current, new int[]{N, N})) {
            //도착
            count++;
            return;
        }
        int beforeR = before[0], beforeC = before[1];
        int currentR = current[0], currentC = current[1];

        //R행, C열로 봐야지. 수학좌표계에서의 (x,y)가아니라
        //1.가로
        if (beforeR == currentR && beforeC + 1 == currentC) {//x좌표 +1 이 현재 좌표인경우 = 가로.
            //가로,대각 옵션 두 가지
            //가로
            if (currentC + 1 <= N && map[currentR][currentC + 1] != 1) {
                dfs(current, new int[]{currentR, currentC + 1});
            }
            //대각
            //오른쪽,아래,대각방향 모두 벽이 아니어야 함.
            if (currentR + 1 <= N && currentC + 1 <= N &&
                    map[currentR + 1][currentC + 1] != 1 && map[currentR + 1][currentC] != 1
                    && map[currentR][currentC + 1] != 1) {
                dfs(current, new int[]{currentR + 1, currentC + 1});
            }
        }

        //2.세로
        if (beforeR + 1 == currentR && beforeC == currentC) {//y좌표 +1 이 현재 좌표인경우 = 세로.
            //세로, 대각 옵션 두 가지
            //세로
            if (currentR + 1 <= N && map[currentR+1][currentC] != 1) {
                dfs(current, new int[]{currentR+1, currentC});
            }
            //대각
            if (currentR + 1 <= N && currentC + 1 <= N &&
                    map[currentR + 1][currentC + 1] != 1 && map[currentR + 1][currentC] != 1
                    && map[currentR][currentC + 1] != 1) {
                dfs(current, new int[]{currentR + 1, currentC + 1});
            }
        }
        //3.대각
        if (beforeR + 1 == currentR && beforeC + 1 == currentC) {//y좌표 +1 이 현재 좌표인경우, x좌표 +1이 현재 좌표인 경우 = 대각
            //가로, 세로, 대각 옵션 세 가지

            //가로
            if (currentC + 1 <= N && map[currentR][currentC + 1] != 1) {
                dfs(current, new int[]{currentR, currentC + 1});
            }
            //세로
            if (currentR + 1 <= N && map[currentR+1][currentC] != 1) {
                dfs(current, new int[]{currentR+1, currentC});
            }
            //대각
            if (currentR + 1 <= N && currentC + 1 <= N &&
                    map[currentR + 1][currentC + 1] != 1 && map[currentR + 1][currentC] != 1
                    && map[currentR][currentC + 1] != 1) {
                dfs(current, new int[]{currentR + 1, currentC + 1});
            }
        }
    }
}
