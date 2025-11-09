import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N + 1];//1~N
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        //방향 그래프
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // u -> v (가중치 1)
            adj[u].add(v);
        }
        bfs(adj, K, X);
        System.out.print(sb.length()==0? -1 : sb);
    }

    static void bfs(ArrayList<Integer>[] adj, int K, int X) {
        int N = adj.length-1;
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[N + 1];
        q.offer(X);
        vis[X] = true;

        int depth = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            if (depth == K) {
                while(sz-- >0) ans.add(q.poll());
                break;
            }
            while (sz-- > 0) {
                int u = q.poll();
                for (int v : adj[u]) {
                    if(vis[v]) continue;
                    vis[v] = true;
                    q.offer(v);
                }
            }
            depth++;
        }

        if (ans.isEmpty()) {
            sb.append(-1);
            return;
        }

        Collections.sort(ans);
        for(int v : ans) sb.append(v).append('\n');
    }
}

