import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101]; //1-based. 1~100
        boolean[] visited = new boolean[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int nxt = cur + j;
                    if (nxt > 100) continue;
                    if (nxt == 100) {
                        System.out.println(count);
                        return;
                    }
                    
                    //사다리/뱀 1회 적용 -> 최종 도착칸
                    //평지 or snakes/ladder
                    int to = (board[nxt] == 0) ? nxt : board[nxt];

                    if(visited[to]) continue;
                    visited[to] = true;
                    q.offer(to);
                }
            }
        }
    }
}

