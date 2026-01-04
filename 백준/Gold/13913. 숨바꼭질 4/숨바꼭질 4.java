import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//숨바꼭질 4
public class Main {
    static int MAX = 100_000;
    static int INF = 1_000_000_000;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
        System.out.print(sb);
    }

    static void bfs(int N, int K) {
        int[] dist = new int[MAX + 1];//1-based
        int[] before = new int[MAX + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(before, -1);

        Queue<Integer> q = new ArrayDeque<>();
        dist[N] = 0;
        before[N] = -1; //처음 시작점의 before는 없음. -1로 표기.
        q.offer(N);

        while (!q.isEmpty()) {
            int x = q.poll();
            int nx;

            //K 찾으면 그만.
            if(dist[K]!=INF) break;

            //1. X-1
            nx = x-1;
            if (nx >= 0) {
                if (dist[nx] == INF) {//처음 방문
                    dist[nx] = dist[x] +1;
                    before[nx] = x;
                    q.offer(nx);
                }//이미 방문했을 때는 별 다른 처리 안해도 된다. 여러 경로를 모두 구해야 하는 것이 아니니까.
            }
            //2. X+1
            nx = x+1;
            if (nx <= MAX) {
                if (dist[nx] == INF) {//처음 방문
                    dist[nx] = dist[x] + 1;
                    before[nx] = x;
                    q.offer(nx);
                }
            }
            //3. 2*X
            nx = 2*x;
            if (nx <= MAX) {
                if (dist[nx] == INF) {
                    dist[nx] = dist[x] + 1;
                    before[nx] = x;
                    q.offer(nx);
                }
            }
        }
        sb.append(dist[K]).append('\n');

        //역 추적
        List<Integer> list = new ArrayList<>();
        int cur = K;
        while (cur != -1) {
            list.add(cur);
            cur = before[cur];
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(' ');
        }
    }
}
