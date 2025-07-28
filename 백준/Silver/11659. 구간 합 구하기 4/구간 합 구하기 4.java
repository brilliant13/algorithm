import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int [N+1]; //1~N
        int i = 1;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        //arr[1] ~ arr[N] 구성끝

        //구간합 구성
        int[] interval_sum = new int[N+1]; // 1~N
        int sum = 0;
        for (int k = 1; k <= N; k++) {
            sum += arr[k];
            interval_sum[k] = sum;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(interval_sum[end] - interval_sum[start - 1]).append('\n');
        }
        System.out.print(sb);


    }
}
