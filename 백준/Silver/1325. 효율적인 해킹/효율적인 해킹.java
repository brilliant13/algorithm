import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int[] seen;
    static int stamp = 1;
    static int[] hackCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //인접리스트 초기화
        adj = new ArrayList[N + 1]; // 1~N
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        //간선입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            adj[start].add(end);
        }

        seen = new int[N + 1];
        hackCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            hackCount[i] = bfs(i);
        }

        int best = 0;
        for (int i = 1; i <= N; i++) {
            best = Math.max(best, hackCount[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackCount[i] == best) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static int bfs(int node) {
        stamp++;
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        seen[node] = stamp;

        while (!q.isEmpty()) {
            int u = q.poll();
            cnt++;
            for (int v : adj[u]) {
                if (seen[v] != stamp) {
                    seen[v] = stamp;
                    q.offer(v);
                }
            }
        }
        return cnt;
    }
}
