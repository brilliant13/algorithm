import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N]; // 0-based
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 자바 기본 정렬 시간복잡도 O(nlogn)

        // Binary Search(이진탐색, 이분탐색)
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            //int lo = arr[0], hi = arr[N - 1];
            int lo = 0, hi = N - 1;

            while (lo < hi) {
                int mid = (lo+hi)>>>1;
                if (x <= arr[mid]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            if(arr[lo]==x) sb.append(1);
            else sb. append(0);

            if(i!=M-1) sb.append('\n');
        }
        System.out.print(sb);


    }
}
