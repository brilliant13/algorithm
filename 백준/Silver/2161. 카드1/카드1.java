import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (q.size() > 1) {
            sb.append(q.poll()).append(" ");
            q.offer(q.poll());
        }
        sb.append(q.poll()).append(" ");

        System.out.println(sb);


    }


}