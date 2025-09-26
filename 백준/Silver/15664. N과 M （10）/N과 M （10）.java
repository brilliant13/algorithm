import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] list,seq;
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

        dfs(0, 0);
        System.out.print(sb);
    }

    //1 7 9 9
    static void dfs(int depth, int start) {
        if (depth == M) { //수열 완성. 오름차순. 중복된 값이 입력으로 들어올 수 있음. 1 7 9 9
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
            return;
        }
        int last = 10001;
        for (int i = start; i < N; i++) {
            if(last == list[i]) continue;
            seq[depth] = list[i];
            last = list[i];
            dfs(depth + 1, i + 1);
        }
    }

}

