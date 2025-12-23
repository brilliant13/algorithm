import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//평범한 배낭
public class Main {
    public static void main(String[] args) throws IOException {
        //무게 W,   가치 V    -> 최대 K만큼의 무게
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //dp[i][w] => dp[i] 무게 조회를 거꾸로하면 1차원으로 변형 가능하다
        //생각해보면, 앞에서부터 진행된다고 했을 때, 이전 상태 비교를 위해 우리는 현재 보고있는 물건의 무게를 뺀다.
        //무게를 빼는 행위는 배열의 앞에 인덱스에 접근하는 것으로, 이 말을 다시 정리하면
        //i=3, dp[7]을 처리할 때, i=2 dp[7-(3번째 물건의 무게=2]가 아니라, i=3에서 dp[5]를 갱신한 상태를 또 사용하는 것이다.
        //그러면 i=3 차례에서의 dp[7]은 3번쨰 물건을 두 번 넣는 행위가 된다.
        // 0/1 knapsack이기 때문에 물건은 있거나 or 없거나이고 물건은 1회밖에 사용 못한다.
        //Weight를 K -> W_i로 줄여나가면 i-1번째 갱신된 상태를 참조하므로
        //dp[i-1][w-W_i]를 고려하는 것과 같다. 즉 dp[i-1][w-W_i] = dp[w-W_i]

        int[] dp = new int[K + 1]; //1-based

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            //뒤에서 앞으로 간다. 같은 물건을 여러 번 쓰지 않게(0/1 kanpsack)
            for (int w = K; w >= W; w--) {
                dp[w] = Math.max(dp[w], dp[w - W] + V);
            }
            //이렇게 바깥 for문 한 번 돌면
            //dp[k] = dp[i][k] 인 것이다.
        }
        //배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력
        System.out.print(dp[K]);
    }
}
