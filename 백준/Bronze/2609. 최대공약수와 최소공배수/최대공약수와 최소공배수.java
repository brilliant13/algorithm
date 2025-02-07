import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        sb.append(gcd(a, b)).append("\n");
        sb.append(lcm(a, b));
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        //greatest common divisor 최대공약수
        if(b==0) return a;
        while (b != 0) {
            int r = a%b;
            a =b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b) {
        //least common multiple 최소공배수
        return a*b/gcd(a,b);
    }


}