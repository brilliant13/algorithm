import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double I = Double.parseDouble(st.nextToken());
        double J = Double.parseDouble(st.nextToken());
        double K = Double.parseDouble(st.nextToken());

        double x = Math.min(A / I, Math.min(B / J, C / K));

        double ra = A - I * x;
        double rb = B - J * x;
        double rc = C - K * x;

        // 오차 허용이 있으니 충분히 출력하면 됨
        System.out.printf("%.6f %.6f %.6f%n", ra, rb, rc);
    }
}