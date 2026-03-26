import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sums = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sums[i] += sums[i-1] + cur; //1-based면 sums[0]은 디폴트로 0
        }

        // 구간합 = 합 배열로 O(N)이 아니라 O(1)로 처리
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sums[j]-sums[i-1]);
            if(k!=M-1) sb.append('\n');
        }
        System.out.print(sb);
    }

}