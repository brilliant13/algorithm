import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] board = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static List<int[]> empties = new ArrayList<>();
    static boolean solved = false;

    static int boxIndex(int r, int c) {
        return (r / 3) * 3 + c / 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int v = line.charAt(j) - '0';
                board[i][j] = v;
                if (v == 0) {
                    empties.add(new int[]{i, j});
                } else {
                    row[i][v] = true;
                    col[j][v] = true;
                    box[boxIndex(i,j)][v] = true;
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

    static void dfs(int idx) {
        if(solved) return;
        if (idx == empties.size()) {
            solved = true;
            return;
        }

        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = boxIndex(r, c);

        for (int num = 1; num <= 9; num++) {
            if(row[r][num] || col[c][num] || box[b][num]) continue;

            board[r][c] = num;
            row[r][num] = col[c][num] = box[b][num] = true;

            //다음 후보군 삽입
            dfs(idx + 1);

            if(solved) return;

            //해결 못 했으면 이번 경우 선택 취소 (BackTracking)
            board[r][c] = 0;
            row[r][num] = col[c][num] = box[boxIndex(r,c)][num] = false;
        }
    }
}