import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //  int → long 변경하여 오버플로우 방지
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        //  long 타입으로 절댓값 계산 후 출력
        System.out.println(Math.abs(X - Y));
    }
}
