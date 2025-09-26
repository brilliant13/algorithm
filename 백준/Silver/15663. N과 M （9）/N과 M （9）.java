import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] seq,list;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
//    static int last = 10001;

    public static void main(String[] args) throws IOException {
        //일단 Permutation 순열 세팅해자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N];
        seq = new int[M];
        used = new boolean[N]; //0..N-1  0-based

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        dfs(0);
        System.out.print(sb);
    }

    // 1 7 9 9
    //숫자 자체의 사용유무 boolean[]을 사용해도 풀릴 것 같다.
    static void dfs(int depth) {

        if (depth == M) { // 같은 수가 여러 번 주어질 수 있는, 순열.
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
//            last = 10001;
            return;
        }

        int last = 10001;

        for (int i = 0; i < N; i++) {
            if(used[i]) continue;
            if(last == list[i]) continue;
            used[i] = true;
            seq[depth] = list[i];
            last = list[i];

            dfs(depth + 1);
            used[i] = false;
        }
    }
}