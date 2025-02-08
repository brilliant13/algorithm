import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibo(N));
    }

    static int Fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return Fibo(n - 2) + Fibo(n - 1);
    }
}