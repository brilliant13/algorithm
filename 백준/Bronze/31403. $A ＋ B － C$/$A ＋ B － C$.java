import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int A, B, C;
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        //출력1
        System.out.println(A + B - C);
        //출력2
        String a = String.valueOf(A);
        String b = String.valueOf(B);
        int AB = Integer.parseInt(a + b);
        System.out.println(AB-C);
    }
}