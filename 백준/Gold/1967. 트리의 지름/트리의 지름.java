import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int n;
    static List<Edge>[] graph;
    static int diameter = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];//1-based
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
        dfs(1, 0);              // 루트는 아무거나(1) 잡아도 됨
        System.out.println(diameter);
    }

    // 반환값: u에서 "아래로" 내려가는 최대 거리 (부모 방향은 제외)
    static int dfs(int u, int parent) {
        int best1 =0, best2=0; //자식 방향 후보 1등, 2등

        for (Edge e : graph[u]) {
            int v = e.to;
            if(v==parent) continue;

            int cand = dfs(v,u) + e.w; //u->v로 내려가는 경로 길이
            if(cand > best1){
                best2 = best1; // 1등이 밀려나서 2등이 됨
                best1 = cand; // 새 후보가 1등
            } else if(cand > best2){
                best2 = cand; // 1등은 아니지만 2등은 됨
            }

        }

        //u를 가운데로 하는 지름 후보
        diameter = Math.max(diameter, best1 + best2);

        //부모에게는 "한 갈래"만 올려줄 수 있음
        return best1;
    }
}
