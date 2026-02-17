import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // 여우 사인이면 정확히 3개의 접촉쌍만 존재해야 함
        if (N != 3) {
            // 입력은 더 읽어줄 필요는 없지만, 안전하게 소비해도 됨
            for (int i = 0; i < N; i++) br.readLine();
            System.out.println("Woof-meow-tweet-squeek");
            return;
        }

        // 기대하는 쌍(정렬해서 문자열로 저장)
        Set<String> expected = new HashSet<>();
        expected.add("1-3");
        expected.add("1-4");
        expected.add("3-4");

        Set<String> got = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 2(검지)나 5(새끼)가 어떤 쌍에라도 등장하면 여우 사인 불가
            if (a == 2 || a == 5 || b == 2 || b == 5) {
                System.out.println("Woof-meow-tweet-squeek");
                return;
            }

            // 무방향이므로 정렬해서 저장
            int x = Math.min(a, b);
            int y = Math.max(a, b);
            got.add(x + "-" + y);
        }

        if (got.equals(expected)) {
            System.out.println("Wa-pa-pa-pa-pa-pa-pow!");
        } else {
            System.out.println("Woof-meow-tweet-squeek");
        }
    }
}
