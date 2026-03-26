import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sums = new int[N];
//        int sum = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            if(i==0) {
                sums[0] = cur;
                continue;
            }
            sums[i] += sums[i-1] + cur;
        }

        // 구간합 = 합 배열로 O(N)이 아니라 O(1)로 처리
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sums[j-1]-sums[i-1]+arr[i-1]);
            if(k!=M) sb.append('\n');
        }
        System.out.print(sb);
    }

}