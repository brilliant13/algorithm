class Solution {
    public int solution(int[][] board, int[][] skill) {
        int r = board.length;
        int c = board[0].length;

        // 차이 배열: 범위를 벗어나서 +1 하기 때문에 +2 크기로 생성
        int[][] diff = new int[r+2][c+2];

        // 1) 모든 스킬을 diff에 기록
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = s[5];

            // type 1: 공격(-), type 2: 회복(+)
            int v = (type == 1 ? -degree : degree);

            diff[r1][c1]     += v;
            diff[r1][c2+1]   -= v;
            diff[r2+1][c1]   -= v;
            diff[r2+1][c2+1] += v;
        }

        // 2) 행 기준 누적합
        for (int i = 0; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                diff[i][j] += diff[i][j-1];
            }
        }

        // 3) 열 기준 누적합
        for (int j = 0; j <= c; j++) {
            for (int i = 1; i <= r; i++) {
                diff[i][j] += diff[i-1][j];
            }
        }

        // 4) diff 결과를 board에 적용하면서 살아있는 건물 개수 세기
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] + diff[i][j] > 0) result++;
            }
        }

        return result;
    }
}
