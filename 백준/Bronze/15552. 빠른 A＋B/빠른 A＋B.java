import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
//            bw.write((N + M) + "\n" );
//            bw.write((N + M)); //  정수형을 ASCII 문자로 출력함
            //bw.write(String.valueOf(N + M));
            //bw.newLine();
            bw.write((N + M)+"\n");
        }
        br.close();

        bw.flush();
        bw.close();


    }
}