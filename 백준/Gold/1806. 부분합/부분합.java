import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //10,000이하의 자연수로 이루어진 길이 N짜리 수열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N]; // 0..N-1  0-based

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int best = Integer.MAX_VALUE;
        int sum = 0, l = 0;

        outer:
        for (int r = 0; r < N; r++) {
            sum += nums[r];

            while (sum >= S) {
                best = Math.min(best, r - l + 1);
                if (best == 1) {
                    break outer;
                }
                sum -= nums[l++];
            }

        }
        System.out.println(best == Integer.MAX_VALUE ? 0 : best);
    }
}
