import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//숨바꼭질 3
public class Main {

    static final int MAX = 100_000;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        int[] dist = new int[MAX + 1]; //1-based. 1~100_000
        Arrays.fill(dist, INF);
        dist[N] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);

        while (!dq.isEmpty()) {

            int cur = dq.poll();
            if (cur == K) {
                return dist[cur];
            }

            //순간이동
            int nx = cur*2;
            if (nx <= MAX && dist[nx] > dist[cur]) {
                dist[nx] = dist[cur];
                dq.addFirst(nx);
            }

            //X-1
            nx = cur-1;
            if (nx >= 0 && dist[nx] > dist[cur]+1) {
                dist[nx] = dist[cur]+1;
                dq.addLast(nx);
            }
            //X+1
            nx = cur +1;
            if (nx <= MAX && dist[nx] > dist[cur] + 1) {
                dist[nx] = dist[cur] + 1;
                dq.addLast(nx);
            }
        }
        return dist[K];
    }
}
