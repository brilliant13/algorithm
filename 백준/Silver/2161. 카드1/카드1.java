import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        int[] q = new int[2 * N];
        for(int i = 1; i <= N; i++) {
            q[i] = i;
        }
        int prev_index = 1;
        int last_index = N;

        while(N-- > 1) {
            sb.append(q[prev_index]).append(" ");
            prev_index++;
            q[last_index + 1] = q[prev_index];
            last_index++;
            prev_index++;
        }
        sb.append(q[prev_index]).append(" ");
        System.out.println(sb);

    }


}