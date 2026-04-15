import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ10986 나머지 합 구하기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1]; // 1-based

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // S[j]-S[i] : 구간 합 (A[i+1] + ... A[j]
        // A[1] , A[2], ... A[N]
        int[] sum = new int[N+1]; // 1-based
        sum[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            sum[i] = sum[i-1]%M + arr[i];
        }

        // (S[j]-S[i])%M == ( (S[j] % M) - (S[i] % M) ) % M
        int[] remainder = new int[M]; // 0..M-1

        sum[1] %= M;
        //if(sum[1]==0) remainder[1]++;
        remainder[sum[1]]++;

        for (int i = 2; i <= N; i++) {
            sum[i] %= M;
            remainder[sum[i]]++;
            //if(sum[i]==0) remainder[i]++;
        }

        long result = 0;

        // (i,j)에서 i==j인 경우
        result += remainder[0];

        for (int i = 0; i < M; i++) {
            if (remainder[i] >= 2) {
                long cur = remainder[i];
                result += cur*(cur-1)/2;
            }
        }

        System.out.println(result);


        // (A-B)%C = ( (A%C) - (B%C) ) % C







    }


}
