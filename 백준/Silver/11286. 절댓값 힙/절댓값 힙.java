import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int absA = Math.abs(a);
                    int absB = Math.abs(b);
                    if (absA == absB) return a - b; // 절댓값이 같으면 실제 값이 작은 게 먼저
                    return absA - absB; //absA - absB < 0 일 때 a가 b보다 앞에옴. 즉 절댓값A가 절댓값B보다 작을 때 A가 앞에옴. 절댓값 작은놈이 앞에옴.
                }
        );
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            } else {
                pq.offer(x);
            }
        }
        System.out.print(sb);

    }
}
