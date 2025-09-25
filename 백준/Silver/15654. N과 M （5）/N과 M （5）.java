import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static boolean[] used;
    static int[] seq;
    static int[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N];
        seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        used = new boolean[list[list.length-1]+1]; //최대 10,000 +1 사용유무 배열 만들어 놓는다.
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) { //조합 구성 끝
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
            return;
        }
        for (int num = 0; num < list.length; num++) {
            if(used[list[num]]) continue;
            used[list[num]] = true;
            seq[depth] = list[num];
            dfs(depth + 1);
            used[list[num]] = false;
        }
    }
}