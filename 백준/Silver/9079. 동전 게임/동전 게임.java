import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //"한 번의 연산" 마스크 만들기
        //XOR 1은 비트 뒤집기. x ^ 1 = ~x
        //9비트 정수로 표현
        int row0 = (1 << 0) | (1 << 1) | (1 << 2); // 0 0000 0111
        int row1 = (1 << 3) | (1 << 4) | (1 << 5); // 0 0011 1000
        int row2 = (1 << 6) | (1 << 7) | (1 << 8); // 1 1100 0000

        int col0 = (1 << 0) | (1 << 3) | (1 << 6); //0 3 6
        int col1 = (1 << 1) | (1 << 4) | (1 << 7);//1 4 7
        int col2 = (1 << 2) | (1 << 5) | (1 << 8);   //2 5 8

        int diagMain = (1 << 0) | (1 << 4) | (1 << 8);//0 4 8
        int diagAnti = (1 << 2) | (1 << 4) | (1 << 6);//2 4 6

        int[] moves = {row0, row1, row2, col0, col1, col2, diagMain, diagAnti};

        StringBuilder sb = new StringBuilder();

        //state = 000 000 000
        while (T-- > 0) {
            int state = 0;
            for (int r = 0; r < 3; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 3; c++) {
                    char ch = st.nextToken().charAt(0);
                    if (ch == 'T') {
                        int idx = r * 3 + c;
                        state |= (1 << idx);
                    }
                }
            }

            int ans = Integer.MAX_VALUE;

            for (int combo = 0; combo < (1 << 8); combo++) {
                int cur = state;
                for (int op = 0; op < 8; op++) { //0000 0000 0부터7까지 연산 인덱스
                    if ((combo & (1 << op)) != 0) { //해당 op가 적용된 조합 //0이 아니면 op번째 연산이 켜져있는것
                        cur ^= moves[op]; //뒤집기 연산
                    }
                } //해당 combo 연산 다 적용한 뒤 검사
                //state 000 000 000  ~ 111 111 111   : 0~ 2^9 -1 : 0~511
                if (cur == 0 || cur == (1 << 9) - 1) {
                    ans = Math.min(ans, Integer.bitCount(combo));
                }
            }
            sb.append(ans == Integer.MAX_VALUE ? -1 : ans).append('\n');

        }
        System.out.print(sb);


    }
}
