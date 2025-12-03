import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            long sum = 0;
//            for (int i = N - 1; i <= M - 1; i++) {
//                sum += comb(i, N - 1);
//            }
            sb.append(comb(M,N)).append('\n');
        }
        System.out.print(sb);
    }

    public static long comb(int n, int r) {
        if (r<0 || r>n) return 0;
        if(r>n-r) r = n-r; //nCr == nC(n-r)

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res *(n-r+i)/i; //항상 나누어 떨어짐. 조합 공식임.
        }
        return res;
    }
}
