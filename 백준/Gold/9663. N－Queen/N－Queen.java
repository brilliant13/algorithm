import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, count;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        count = 0;
        dfs(0);
        System.out.print(count);
    }

    static void dfs(int depth) {
        if (depth == N) { //N행 모두 배치완료
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (map[depth][c] > 0) continue; //막힌 칸이면 패스
            place(depth, c);
            dfs(depth + 1);
            remove(depth, c);
        }
    }

    static void place(int depth, int c) {
        //현재 칸: 퀸 표시(+1)
        map[depth][c]++;

        //같은 열(아래쪽만)
        for(int x = depth+1; x<N; x++) map[x][c]++;

        //대각선 오른쪽아래
        for (int x = depth + 1, y = c + 1; x < N && y < N; x++, y++) map[x][y]++;

        //대각선 왼쪽아래
        for (int x = depth + 1, y = c - 1; x < N && y >= 0; x++, y--) map[x][y]++;
    }

    static void remove(int depth, int c) {
        //되돌리기(배치의 정확한 역연산). 백트랙킹
        map[depth][c]--;
        for(int x = depth+1; x<N; x++) map[x][c]--;
        for (int x = depth + 1, y = c + 1; x < N && y < N; x++, y++) map[x][y]--;
        for (int x = depth + 1, y = c - 1; x < N && y >= 0; x++, y--) map[x][y]--;
    }

}
