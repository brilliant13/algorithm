import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 1) continue;

            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(x); j++) {
                if (x % j == 0) {
                    isPrime =false;
                    break;
                }
            }
            if(isPrime) count++;
        }
        System.out.println(count);
    }
}