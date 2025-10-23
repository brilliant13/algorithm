import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //부분 수열 = 연속항
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N]; //0..N
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        for (int i : arr) {
//            System.out.println("i = " + i);
//        }

        int count = 0;

        //N개의 정수로 이루어진 수열
        // 2^5의 경우의 수가 있다.
        // State = 00000 ~ 11111 : 0 ~ 2^5 - 1 : 0~31 : 32개의 경우의 수
        // 상태마스크에서 몇 번째를 켤지 -> 그게 S 인지 확인하면 된다.
        for (int state = 1; state < (1 << N); state++) { //모든 조합 마스킹. 완전탐색
            //state가 0이면 빈집합 포함한다. 근데 문제에서는 크기가 양수인 부분수열 중이라고 했으니 state =0 은 제외해야함.
            //state =0 에서도 S가 0이면 count++해주니까 문제 틀린다.
            int sum = 0;
            // state 0b 01011
            //비트 켜져있는지 확인
            for (int i = 0; i < N; i++) {
                if ((state & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }
            //켜진 마스크로 합 계산 완료. S랑 같은지 비교
            if(sum == S) count++;
        }
        System.out.print(count);

    }

}
