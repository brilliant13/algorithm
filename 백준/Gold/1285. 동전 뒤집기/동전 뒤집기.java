import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        //1:59 ~
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //각 열 j에 대해: 행 방향으로 T(=1) / H(=0)을 담은 N비트 마스크
        //열의 상태 Mask (전체자리가 아니라 열로 묶어서 상태를 표현)

        int[] col = new int[N]; //col[j]의 i번째 비트:
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'T') {
                    col[j] |= (1 << i);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        //행 뒤집기 마스크만 2^N으로 완전탐색하자
        int limit = 1 << N; //행 뒤집기 마스크 총 경우의 수 2^N

        //전체 행 뒤집기 경우의 수 완전 탐색.
        for (int rm = 0; rm < limit; rm++) {

            //rm = rowMask. 행 뒤집기 한 가지 케이스 선택 완료 -> 모든 열에 적용해야지.
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int cnt = Integer.bitCount(col[j] ^ rm); // 해당 행 뒤집기 경우의 수를 col[j]열에 적용 -> 이 열의 T 개수
                sum += Math.min(cnt, N - cnt); //이번 차례의 열을 뒤집을지 말지 선택 => 그리디. 탐욕적으로 매순간 최선을 선택하고, 되돌리지않는다.
                //구조상 문제없으면 그리디. => 행 뒤집기와 열뒤집기는 완전독립이기 때문에, 이기적으로 최선을 선택해도 된다. 앞 열에서 적은 수의 T를 선택한다고해서
                //뒤차례의 열의 T개수에 영향을 주는 게 아니니까
                if (sum >= ans) break; //가지치기 pruning(이미 최솟값 넘으면 중단)
            }
            if (ans > sum) ans = sum;
        }
        System.out.println(ans);

    }


}

