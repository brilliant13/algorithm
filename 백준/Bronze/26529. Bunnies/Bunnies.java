import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] fibs = new int[46]; //0~45

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //0~45
        StringBuilder sb = new StringBuilder();

        fibs[0] = 1;
        fibs[1] = 1;
        for (int i = 2; i <= 45; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibs[n]).append('\n');
        }
        System.out.print(sb);
    }

    static int fib(int n) {
        if(n==0) return fibs[0];
        if(n==1) return fibs[1];
        if(fibs[n]!=-1) return fibs[n];

        //O(n)
        //DP(bottom up)(Tabulation)
        for (int i = 2; i <= n; i++) {
            if (fibs[i] == -1) {
                fibs[i] = fibs[i - 2] + fibs[i - 1];
            } else {
                continue;
            }
        }
        return fibs[n];
        //top down(재귀 메모이제이션)  or bottom up (dp, 반복문)


    }
}
