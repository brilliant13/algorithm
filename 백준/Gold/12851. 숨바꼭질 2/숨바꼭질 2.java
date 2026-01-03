import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//숨바꼭질 2
public class Main {
    static final int MAX = 100_000;
    //    static final int INF = 1_000_000_000;
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
        //거리 배열로 방문처리
        int[] dist = new int[MAX + 1]; //1-based
        int[] ways = new int[MAX + 1];
        Arrays.fill(dist, -1);

        //간선이 모두 1이다.
        //재방문하는 경우는 패스. 이미 최단 거리가 아니기 떄문에. -> 아니지 재방문해도 모든 경로를 세야 하기 떄문에 체크해야 한다.

        Queue<Integer> q = new LinkedList<>();
        dist[N] = 0;
        ways[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int x = q.poll();

            //K의 최단시간을 이미 찾았고, 그보다 깊은 레벨이면 더 볼 필요 없음
            if (dist[K] != -1 && dist[x] > dist[K]) break;

            // 1) x-1
            int nx = x - 1;
            if (nx >= 0) {
                if (dist[nx] == -1) {                 // 처음 방문
                    dist[nx] = dist[x] + 1;
                    ways[nx] = ways[x];
                    q.add(nx);
                } else if (dist[nx] == dist[x] + 1) { // 같은 최단거리로 또 도착
                    ways[nx] += ways[x];
                }
            }
            // 2) x+1
            nx = x + 1;
            if (nx <= MAX) {
                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    ways[nx] = ways[x];
                    q.add(nx);
                } else if (dist[nx] == dist[x] + 1) {
                    ways[nx] += ways[x];
                }
            }
            // 3) 2*x
            nx = x * 2;
            if (nx <= MAX) {
                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    ways[nx] = ways[x];
                    q.add(nx);
                } else if (dist[nx] == dist[x] + 1) {
                    ways[nx] += ways[x];
                }
            }

        }
        sb.append(dist[K]).append('\n');
        sb.append(ways[K]).append('\n');
    }
}
