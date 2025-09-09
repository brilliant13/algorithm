import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pr = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pr.isEmpty()) {
                    sb.append(0).append('\n');
                    continue;
                }
                sb.append(pr.poll()).append('\n');
            } else {
                pr.offer(x);
            }
        }
        System.out.print(sb);


    }
}
