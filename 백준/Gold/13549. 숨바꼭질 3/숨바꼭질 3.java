import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//숨바꼭질 3
public class Main {
    static final int MAX = 1000000;
    static final int INF = 1_000_000_000;


    static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));

    }

    static int bfs(int N, int K) {
        //수빈이:N, 동생:K
        // dist[x] = N에서 x까지 최소 시간
        int[] dist = new int[MAX + 1]; // 1..based
        Arrays.fill(dist, INF);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[N] = 0;
        dq.offer(N);


        while (!dq.isEmpty()) {
            int x = dq.poll(); //dq.pollFirst()

            if (x == K) return dist[x]; //이미 최솟값 도달

            //1.순간이동 x*2 (비용 0)
            int nx = x * 2;
            if (nx <= MAX && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.addFirst(nx); //비용 0이므로 앞쪽에
            }

            //2. x-1 (비용 1)
            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx); //비용 1 -> 뒤쪽
            }

            //3. x+1 (비용 1)
            nx = x + 1;
            if (nx <= MAX && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

        }
        return dist[K];

    }
}
