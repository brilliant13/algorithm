import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == b && b == c && a == 0) {
                break;
            }
            int max = Math.max((Math.max(a, b)), c);
            if (max == a) {
                if (max * max == b * b + c * c) {
                    sb.append("right").append("\n");
                } else {
                    sb.append("wrong" + "\n");
                }
            } else if (max == b) {
                if (max * max == a * a + c * c) {
                    sb.append("right").append("\n");
                } else {
                    sb.append("wrong" + "\n");
                }
            } else {
                if (max * max == b * b + a * a) {
                    sb.append("right").append("\n");
                } else {
                    sb.append("wrong" + "\n");
                }
            }

        }
        br.close();
        System.out.println(sb);

    }
}