import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N]; //정렬 해야 돼서 0부터 n-1까지만. 입력값으로 0 들어올 수도 있으니까.
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int r = 0;
        int ans = Integer.MAX_VALUE;

        //차이가 M보다 크고, 최소인 값을 찾아라.
        for (int i = 0; i < N; i++) {
            //포인터로 돌자
            while (r < N && A[r] - A[i] < M) r++;
            if (r == N) break;
            ans = Math.min(ans, A[r] - A[i]);
        }
        System.out.println(ans);
        
    }
}