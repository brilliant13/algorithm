import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];

    // used[0][r][num] = r행에 num 사용 여부
    // used[1][c][num] = c열에 num 사용 여부
    // used[2][b][num] = b박스에 num 사용 여부
    static boolean[][][] used = new boolean[3][9][10];

    static List<int[]> empties = new ArrayList<>();

    static int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    // 정답 하나 찾으면 true 반환 (solved 플래그 없이 종료)
    static boolean dfs(int idx) {
        if (idx == empties.size()) return true; // 빈 칸 다 채움

        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = boxIndex(r, c);

        for (int num = 1; num <= 9; num++) { // 1..9 순서 => 사전식 최소
            if (used[0][r][num] || used[1][c][num] || used[2][b][num]) continue;

            // 놓기
            board[r][c] = num;
            used[0][r][num] = used[1][c][num] = used[2][b][num] = true;

            if (dfs(idx + 1)) return true; // 성공하면 즉시 전파

            // 되돌리기(백트래킹)
            board[r][c] = 0;
            used[0][r][num] = used[1][c][num] = used[2][b][num] = false;
        }

        return false; // 이 칸에 어떤 숫자도 못 놓으면 실패
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int v = line.charAt(j) - '0';
                board[i][j] = v;
                if (v == 0) {
                    empties.add(new int[]{i, j});
                } else {
                    int b = boxIndex(i, j);
                    used[0][i][v] = true;
                    used[1][j][v] = true;
                    used[2][b][v] = true;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) sb.append(board[i][j]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
