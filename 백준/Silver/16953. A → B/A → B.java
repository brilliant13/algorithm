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

        int cnt = 0;

        while (B > A) {
            cnt++;

            if (B % 10 == 1) {           // 끝자리가 1이면 1 제거
                B = (B - 1) / 10;
            } else if (B % 2 == 0) {     // 짝수면 2로 나누기
                B /= 2;
            } else {                     // 둘 다 아니면 더 이상 A로 못 줄임
                System.out.println(-1);
                return;
            }
        }

        if (B == A) {
            // 연산 횟수 + 1 출력
            System.out.println(cnt + 1);
        } else {
            System.out.println(-1);
        }
    }
}
