import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashMap;
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
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            //친구 관계 수
            int F = Integer.parseInt(br.readLine());
            //친구이름 중복해서 들어올 수도 있지만, 일단 F*2만큼이 최대니까 커버할 수 있도록 배열생성

            int[] size = new int[2 * F + 1]; // 0..2F


            HashMap<String, Integer> map = new HashMap<>();

            //DSU
            //친구이름 중복해서 들어올 수도 있지만, 일단 F*2만큼이 최대니까 커버할 수 있도록 배열생성
            parent = new int[F * 2 + 1]; // 1..F*2
            for (int j = 1; j < F * 2 + 1; j++) { // [1] ~ [F*2]
                parent[j] = j;
            }

            int idx = 1;

            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());

                String U = st.nextToken();
                int UIdx;
                //이름 처음 들어왔다면
                if (!map.containsKey(U)) {
                    map.put(U, idx);

                    size[idx] = 1;
                    UIdx = idx++;
                } else { //이미 한번 들어온 이름잉라면
                    UIdx = map.get(U);
                }

                String V = st.nextToken();
                int VIdx;
                //이름 처음 들어왔다면
                if (!map.containsKey(V)) {
                    map.put(V, idx);

                    size[idx] = 1;

                    VIdx = idx++;
                } else { //이미 한번 들어온 이름이라면
                    VIdx = map.get(V);
                }

                int ru = find(UIdx);
                int rv = find(VIdx);

                //이미 같은 컴포넌트, 집합이라면
                if (ru == rv) {
                    sb.append(size[ru] + "\n");
                } else { //다른 컴포넌트라면

                    //더 큰 집합을 루트로
                    if (size[ru] < size[rv]) {
                        int tmp = ru; ru = rv; rv = tmp;
                    }
                    parent[rv] = ru;
                    size[ru] += size[rv];
                    sb.append((size[ru])).append('\n');
                }
            }
        }
        System.out.print(sb);
    }
}
