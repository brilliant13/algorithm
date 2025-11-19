import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        //0 , 1 ... n   (n+1)개의 집합
        int n = Integer.parseInt(st.nextToken());
        //연산의 갯수 m
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        parent = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0) {
                // 합집합 :  0 a b => a가 포함되어있는 집합과, b가 포함되어 있는 집합을 합친다.
                union(a,b);
            } else {
                // find : 1 a b =>  두 원소가 같은 집합에 포함되어 있는지 확인하는 연산
                if (find(a) == find(b)) {
                    sb.append("yes" + '\n');
                } else {
                    sb.append("no" + '\n');
                }
            }
        }
        System.out.print(sb);


    }
}

