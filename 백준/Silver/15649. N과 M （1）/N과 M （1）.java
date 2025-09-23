import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] seq;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        used = new boolean[N + 1]; //1..N

        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        //base case
        if (depth == M) { //길이 M 완성 -> 출력
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(i + 1 == M ? '\n' : ' ');
            }
            return;
        }
        for (int num = 1; num <= N; num++) { //사전순 보장
            if(used[num]) continue; //중복 방지
            used[num] = true;
            seq[depth] = num;
            dfs(depth+1);
            used[num] = false; //backtrack
        }
    }
}