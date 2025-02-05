import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 3<=N<=100)
        int N = Integer.parseInt(st.nextToken());
        // 10<=M<=300,000
        int M = Integer.parseInt(st.nextToken());
        // N장의 카드입력
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // nC3  n Combination 3 가지의 경우의 수 중 M을 넘지않는 최대값
        int max = 0;
        int c = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i+1; j < N - 1; j++) {
                for (int k = j+1; k < N; k++) {
                    c = arr[i] + arr[j] + arr[k];
                    if (c > max && c <= M) {
                        max = c;
                    }
                }
            }
        }
        System.out.println(max);
    }
}