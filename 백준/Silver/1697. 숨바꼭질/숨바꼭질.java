import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int MAX = 100000;
        int[] dist = new int[MAX + 1]; //dist[x] = 시작점N에서 x까지의 최소 이동 시간
        Arrays.fill(dist, -1);  // -1은 방문 아직 안 함.

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) break; // brother 찾으면 종료

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nx : nexts) {
                if (0 <= nx && nx <= MAX && dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    q.add(nx);
                }
            }
        }
        System.out.println(dist[K]);
    }
}
