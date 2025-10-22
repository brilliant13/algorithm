import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //연산 Mask
        int row0 = (1 << 0) | (1 << 1) | (1 << 2);// 0 1 2 // 000 000 111
        int row1 = (1 << 3) | (1 << 4) | (1 << 5);// 3 4 5
        int row2 = (1 << 6) | (1 << 7) | (1 << 8);// 6 7 8

        int col0 = (1 << 0) | (1 << 3) | (1 << 6); //0 3 6
        int col1 = (1 << 1) | (1 << 4) | (1 << 7); //1 4 7
        int col2 = (1 << 2) | (1 << 5) | (1 << 8); //2 5 8

        int diagMain = (1 << 0) | (1 << 4) | (1 << 8); // 0 4 8
        int diagAnti = (1 << 2) | (1 << 4) | (1 << 6); // 2 4 6

        int moves[] = {row0, row1, row2, col0, col1, col2, diagMain, diagAnti};
        //0..7 => 8가지. 총 연산 경우의 수는 2^8
        //비트로 표현 combo = 0000 0000 ~ 1111 1111 : 0~ 2^8-1 : 256개

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int state = 0; // 000 000 000
            // 000 000 000 ~  111 111 111 : 0~ 2^9-1 = 512개
            int ans = Integer.MAX_VALUE;

            for (int r = 0; r <= 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c <= 2; c++) {

                    char ch = st.nextToken().charAt(0);
                    //T = 1 , H = 0
                    // 평탄화 idx = r*행의 개수 + c
                    if (ch == 'T') {
                        int idx = r * 3 + c;
                        state |= (1 << idx);
                    }
                }
//                System.out.println("State : " + Integer.toString(state, 2));
            }
            //state  001 110 110

            //완전탐색. 연산은 총 8개. on/off 가능한 연산은 2^8
            // 연산 Mask = Combo = 0000 0000 ~ 1111 1111
            // 0 ~ 2^8-1 = 0 ~ 255 : 256가지의 경우의 수
            //연산의 순서는 상관없음. 결과를 놓고 전체가 1인지 0인지 비교하는 것이기 때문이다.
            for (int combo = 0; combo < (1 << 8); combo++) {
                //0 ~ 255(2^8-1)
                //하나의 조합인 combo가 오면, 이건 연산의 경우의 수니까
                //어떤 연산이 켜져있는지 확인하고, 그 연산을 적용해서 count해준다.
                //그 연산 비트가 1로 켜져있으면 bitcount로 세준다.
                int cur = state;
                for (int op = 0; op < 8; op++) {
                    if ((combo & (1 << op)) != 0) { //해당 op번째 연산이 켜져있다!
                        //current상태에 적용해준다.
                        //cur = 001 110 110 연산 마스크랑 XOR해주면 뒤집힌다.
                        cur ^= moves[op];
                    }
                }//combo 조합에서 켜져있는 전체 연산 조합을 state에 적용시켜주고, 비교한다.
                if (cur == 0 || cur == (1 << 9) - 1) {
                    //000 000 000 or 111 111 111
                    //combo에서 켜진 비트 세준다.
                    ans = Math.min(ans, Integer.bitCount(combo));
                }
            }
            //combo 다 돌고  최솟값을 넣어준다.
            sb.append(ans == Integer.MAX_VALUE ? -1 : ans).append('\n');
        }
        System.out.print(sb);
    }
}
