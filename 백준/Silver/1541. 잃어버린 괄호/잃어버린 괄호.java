import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int minus_sum = 0;
        String changer = "";
        boolean flag = false;

        char[] chars = br.readLine().toCharArray();
        //연산자 만나면 그 전까지의 문자를 숫자로 묶어서 처리
        for (char ch : chars) {
            if (ch == '+') {
                if (!flag) {
                    ans += Integer.parseInt(changer);
                } else {
                    minus_sum += Integer.parseInt(changer);
                }
                changer = "";
            } else if (ch == '-') {
                if (!flag) {
                    ans += Integer.parseInt(changer);
                } else {
                minus_sum += Integer.parseInt(changer);
                }
                changer = "";
                flag = true;
            } else { //숫자라면
                changer += ch;
            }
        }
        if (flag) {
            minus_sum += Integer.parseInt(changer);
        } else {
            ans += Integer.parseInt(changer);
        }
        System.out.println(ans-minus_sum);

    }
}