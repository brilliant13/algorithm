import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int X,Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String number="";
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            //층번호
            if (N % H == 0) {
                Y = H;
            } else {
                Y = N%H;
            }
            //방번호
            if (N % H == 0) {
                X = N/H;
            } else {
                X = (N/H)+1;
            }

            if (X < 10) {
                number = "0" + X;

            } else {
                number =""+X;
            }
            sb.append(Y).append(number).append('\n');
        }
        System.out.println(sb);
    }
}