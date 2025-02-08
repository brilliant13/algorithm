import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //생성자는 N보다 작음. BruteForce (브루트포스)
        for (int i = 1; i < N; i++) {
            //자릿수 합 찾기
            int number = i;
            int sum =0;
            while (number != 0) {
                sum+=number%10;
                number/=10;
            }
            //생성자 찾기
            if (N == sum + i) {
                result=i;
                break;
            }
            result =0;
        }
        System.out.println(result);
    }
}