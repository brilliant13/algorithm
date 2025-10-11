import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 비행기에 있는 음식 수
        int ca = Integer.parseInt(st.nextToken()); // 치킨
        int ba = Integer.parseInt(st.nextToken()); // 소고기
        int pa = Integer.parseInt(st.nextToken()); // 파스타

        // 주문한 음식 수
        st = new StringTokenizer(bf.readLine());
        int cr = Integer.parseInt(st.nextToken()); // 치킨
        int br = Integer.parseInt(st.nextToken()); // 소고기
        int pr = Integer.parseInt(st.nextToken()); // 파스타

        int sadCust = 0; // 원하는 식사 받지 못하는 손님 수

        // 원하는 식사 받지 못하는 손님 수 구하는 코드
        if (ca - cr < 0) {
            sadCust += cr - ca;
        }
        if (ba - br < 0) {
            sadCust += br - ba;
        }
        if (pa - pr < 0) {
            sadCust += pr - pa;
        }

        System.out.println(sadCust);
    }
}