import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int u;
        int v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1]; // 1..V
        //처음에는 자기 자신이 부모(root). 각 정점이 각각의 컴포넌트
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        //Kruskal
        //1. 간선 가중치 순으로 정렬. Edge clss 만들어도 되고, int[]{1,2,3} 해도 되고
        //2. Union Find(DSU) : 같은 컴포넌트면 제외, 다른 컴포넌트면 선택
        //3. 간선 N-1개 뽑으면, 스패닝 트리완성 -> 비용 오름차순으로 뽑았으니 Minimum Spanning Tree 완성

        //Prim : 선캑된  정점은 선택안하고 가중치 작은 순으로 선택해 나간다.

        //간선 관리용 자료구조 List
        List<Edge> list = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            Edge edge = new Edge(A, B, C);
            list.add(edge);
        }

        //가중치 오름차순 정렬
        list.sort(Comparator.comparingLong(a -> a.w));

        //간선 한개씩 뽑으면서 같은 컴포넌트인지 아닌지 구별해서 선택 (Disjoint Set Union)
        int count = 0;
        long weight = 0;
        for (Edge edge : list) {
            if (!union(edge.u, edge.v)) continue;
            weight += edge.w;
            count++;
            if(count==V-1) break;
        }
        System.out.println(weight);
        //N-1개 뽑으면 MST완성

    }
}
