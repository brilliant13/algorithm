import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        System.out.println(pow(A,B,C));
    }

    static long pow(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        long half = pow(a,b/2,c); // a^(b/2)%2
        long result = (half*half)%c;
        if (b % 2 == 1) {
            result = (result*a)%c;
            //(half*half*a%c)%c -> half 곱하다가 overflose가능성
            //모듈려 분할정복 공식에의해 %c 중간중간넣어줘도됨. result로 1차 처리시키고 a곱하는게 크기 준다
        }
        return result;
    }

}
