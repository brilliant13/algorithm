import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> parties = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int knowTrueNum = Integer.parseInt(st.nextToken());
        int[] truth = new int[knowTrueNum];
        for (int i = 0; i < knowTrueNum; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int[] arr = new int[P];
            for (int j = 0; j < P; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(arr);
        }

        //모든 파티를 다 본 후에 한번에 결정한다.
        parent = new int[N + 1]; //0..1..N
        for(int i=1; i<=N; i++) parent[i] = i;

        //각 파티마다, 같은 파티 참가자들을 union
        for (int[] party : parties) {
            for (int j = 1; j < party.length; j++) {
                union(party[0], party[j]);
            }
        }

        boolean[] truthRoot = new boolean[N + 1];
        for (int t : truth) {
            truthRoot[find(t)] = true; //t가 속한 집합의 루트는 "진실 집단"
        }

        //이제야 각 파티를 보면서 "거짓말 가능?"을 판정하자
        int answer = 0;
        partyLoop:
        for (int[] party : parties) {
            for (int person : party) {
                if (truthRoot[find(person)]) {
                    //이 파티에 진실 집단 존재 -> 과장 불가 -> 진실만 가능
                    continue partyLoop;
                }
            }
            //여기 까지 왔다는 건, 진실 집단 사람 한 명도 없다는 뜻
            answer++;
        }
        System.out.println(answer);

    }
}
