import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[N+1]; //1~N
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj[A].add(B);
            adj[B].add(A);
        }

        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[N + 1]; //1~N

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1]= true;


        //1이 루트. 1부터 bfs하면 이후 것들은 순서대로 child
        //트리구조는 부모가 하나기 때문이다.
        while (!q.isEmpty()) {
            int parent = q.poll();
            for (int nxt : adj[parent]) {
                if(visited[nxt]) continue;
                visited[nxt] = true;
                map.put(nxt, parent);
                q.offer(nxt);
            }
        }
        //2번노드부터 부모노드 출력
        for (int i = 2; i <= N; i++) {
            sb.append(map.get(i)).append((char)10); //아스키코드 10이 Line Feed. LF임
        }
        System.out.print(sb);
    }
}
