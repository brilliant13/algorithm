import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//평범한 배낭2
public class Main {
    public static void main(String[] args) throws IOException {
        //같은 물건이 개수가 K개네?
        //K개를 쌩짜로 반복하면 O(N*무게*K) 시간복잡도 초과. TLE
        //이진분할. logN
        //1 2 4 6 => 13    log13 = 3.xxx
        //즉 3.xx를 곱하는 거랑 쌩자 K 범위(1<= <=10,000) 만을 곱하는 거랑 엄청난차이
        //N * M * K = 100 * 10,000 * 10,000 => 100억 -> 100초
        //N * M * logK = 100 * 10,000 * 14 => 1,400만 -> 0.14초 충분.
        //2^14 = 16,384
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //이진 분할된 물건들을 저장
        List<int[]> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            //이진 분할
            int cnt = 1;
            while (K >= cnt) {
                items.add(new int[]{V * cnt, C * cnt});
                K -= cnt;
                cnt *= 2;
            }
            //남은 개수 처리
            if (K > 0) {
                items.add(new int[]{V * K, C * K});
            }
        }

        //일반 0/1 배낭 DP
        int[] dp = new int[M + 1];

        for (int[] item : items) {
            int weight = item[0];
            int value = item[1];

            //뒤에서부터 갱신 (0/1 배낭)
            for (int j = M; j >= weight; j--) {
                //뽑거나 or 뽑지 않거나.
                //{V*1 , C*1}이 뽑힌 상태에서 {V*2, C*2}를 뽑으면
                //3을 표현할 수 있다. (1+2 = 3) {V*3, C*3}
                //결국 반복을 한바퀴 다 돌면 최대 무게상태에서의 최대 가치를 계속 누적 갱신해가는 것이다.
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        //마지막 갱신에서, 최대무게가 M일 때의 최대가치를 읽어주면 답이다.
        System.out.print(dp[M]);

    }
}
