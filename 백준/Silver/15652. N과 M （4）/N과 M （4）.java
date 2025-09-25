import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M]; //0..M-1  0-based

        dfs(1, 0);
        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == M) { //조합완성
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
            return;
        }
        for (int num = start; num <= N; num++) {
            seq[depth] = num;
            dfs(num, depth + 1);
        }
    }

}
