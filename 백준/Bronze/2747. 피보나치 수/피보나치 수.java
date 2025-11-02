import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [] memo = new int[46];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    static int fibo(int n) {
        if(n <= 1) return n;
        if(memo[n] != 0) return memo[n];
        return memo[n] = fibo(n - 2) + fibo(n - 1);
    }
}