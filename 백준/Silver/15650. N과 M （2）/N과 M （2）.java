import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//    static boolean[] used;
    static int[] seq;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        used = new boolean[N + 1]; //1..N
        seq = new int[M];//0..M-1

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        //Base case
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(i + 1 == M ? '\n' : ' ');
            }
            return;
        }

        //오름차순 강제: 이번 깊이에서 시도할 최소 숫자
        int start = (depth == 0) ? 1 : seq[depth-1]+1;

        for (int num = start; num <= N; num++) { //사전순 + 오름차순 보장
//            if(used[num]) continue; //조합에선 사실 필요없음.
//            used[num] = true;
            seq[depth] = num;
            dfs(depth+1);
//            used[num] = false;
        }

    }
}
