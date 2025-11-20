import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();

        //Union Find
        //처음 각 노드의 root는 자기 자신
        parent = new int[N + 1]; //1..N
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c});
        }

        //가중치 오름차순 정렬
        //{1,2,5}
        list.sort(Comparator.comparingInt(a -> a[2]));
//        for (int[] ints : list) {
//            for (int anInt : ints) {
//                System.out.println("anInt = " + anInt);
//            }
//        }

        //DSU(Disjoint Set Union)
        //같은 컴포넌트면 제외, 다른 컴포넌트면 Union(합병)
        //간선 N-1개 까지 -> 최소신장트리 완성

        int cost = 0;
        int size = 0;
        for (int[] cur : list) {
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];
            if (!union(a, b)) continue;
            cost += c;
            size++;
            if (size == N - 1) break;
        }
        System.out.print(cost);

    }
}
