import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (isSqure(n)) { //제곱수면
            System.out.println(1);
            return;
        }

        if (isFourSquaresOnly(n)) { //레장드르: 4^a(8b+7) 형태
            System.out.println(4);
            return;
        }

        //2개 인지 검사 : n - i^2가 제곱수인지
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int rest = n - i*i;
            if (isSqure(rest)) {
                System.out.println(2);
                return;
            }
        }

        System.out.println(3);

    }

    private static boolean isSqure(int x) {
        int r = (int)Math.sqrt(x);
        return r*r==x;
    }
    // n = 4^a * (8b+7) 형태인지. -> 3개의 제곱수로 표현 불가능 -> 4
    private static boolean isFourSquaresOnly(int n) {
        while(n%4==0) n/=4; // 4의 거듭제곱 인자 제거
        return n%8 == 7;
    }
}