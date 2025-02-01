import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fac = 1;
        for (int i = 1; i <= N; i++) {
            fac *= i;
        }
        System.out.println(fac);

    }
}
