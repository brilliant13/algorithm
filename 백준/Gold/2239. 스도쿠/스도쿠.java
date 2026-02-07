import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] board = new int[9][9];
    static int[] rowMask = new int[9];
    static int[] colMask = new int[9];
    static int[] boxMask = new int[9];
    static List<int[]> empties = new ArrayList<>();

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
                    int bit = 1 << (v - 1);
                    int b = boxIndex(i, j);
                    rowMask[i] |= bit;
                    colMask[j] |= bit;
                    boxMask[b] |= bit;
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

    static boolean dfs(int idx) {
        if (idx == empties.size()) {
            return true;
        }

        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = boxIndex(r, c);

        int used = rowMask[r] | colMask[c] | boxMask[b];
        int avail = (~used) & 0x1FF;

        for (int num = 1; num <= 9; num++) {
            int bit = 1 << (num - 1);
            if((avail&bit)==0) continue;

            board[r][c] = num;
            rowMask[r] |= bit;
            colMask[c] |= bit;
            boxMask[b] |= bit;

            //다음 후보군 삽입
            if(dfs(idx + 1)) return true;

            board[r][c] = 0;
            rowMask[r] ^= bit;
            colMask[c] ^= bit;
            boxMask[b] ^= bit;
        }
        return false;
    }
}