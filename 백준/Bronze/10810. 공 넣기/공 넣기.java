import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1]; //1~N 바구니
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = from; j <= to; j++) {
                arr[j] = k;
            }
        }
        StringBuilder sb = new StringBuilder();
//        for (int value : arr) {
//            sb.append(value).append(' ');
//        }
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);

    }


}
