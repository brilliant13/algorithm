import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] cable = new long[K];
        //K개 랜선 입력
        for (int i = 0; i < K; i++) {
            cable[i] = Long.parseLong(br.readLine());
        }
        long low = 1;
        long high = Arrays.stream(cable).max().getAsLong();
        long answer = 0;

        //이분탐색, 이진탐색
        while (low <= high) {

            long mid = (low + high) / 2;
            long pieces = 0;
            for (long len : cable) pieces += len / mid;

            if (pieces >= N) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

