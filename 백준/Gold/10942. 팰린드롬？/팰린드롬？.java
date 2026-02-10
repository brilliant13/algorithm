import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N = 2,000
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //1 2 1 3 1 2 1
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] palindromeDP = new boolean[N + 1][N + 1];
        //전처리 O(N^2)

        //길이1
        for (int i = 1; i <= N; i++) {
            palindromeDP[i][i] = true;
        }

        //길이2
        for (int i = 1; i + 1 <= N; i++) {
            palindromeDP[i][i+1] = (nums[i] == nums[i + 1]);
        }

        //길이3
        for (int len = 3; len <= N; len++) {
            for (int s = 1; s + len - 1 <= N; s++) {
                int e = s + len - 1;
                palindromeDP[s][e] = (nums[s]==nums[e]) && palindromeDP[s+1][e-1];
            }
        }

        //M=1,000,000
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            //홍준이가 명우에게 한 질문 S와 E
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(palindromeDP[s][e] ? 1 : 0).append('\n');
        }
        System.out.print(sb);





    }
}