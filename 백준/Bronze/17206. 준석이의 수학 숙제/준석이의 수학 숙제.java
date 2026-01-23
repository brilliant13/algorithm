import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[80001];
        answer[10] = 25;
        int tmp = 25;
        for (int i = 11; i <= 80000; i++) {
            if (i % 3 == 0 || i % 7 == 0) {
                answer[i] = tmp + i;
                tmp = answer[i];
            }
            else
                answer[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(answer[n] + "\n");
        }
        System.out.println(sb);
    }
}