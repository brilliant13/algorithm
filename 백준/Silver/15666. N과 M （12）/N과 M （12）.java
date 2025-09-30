import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] seq,list;
    static StringBuilder sb = new StringBuilder();
    //입력값 dedup버전 vs dedup없는 풀이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[N]; //0..N-1
        seq = new int[M]; // 0..M-1 0-based

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        //9 7 9 1
        Arrays.sort(list);
        //1 7 9 9
//        N = list.length;
        dfs(0,0);
        System.out.print(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) { // 중복된 값이 입력으로 들어올 수 있는 비내림차순 중복순열
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
            return;
        }
        int last = Integer.MIN_VALUE; //깊이 마다 last값 기록. 해당 깊이에서 이전값 중복되게 안뽑도록
        for (int i = start; i < N; i++) {
            if(last == list[i]) continue;
            seq[depth] = list[i];
            last = list[i];
            dfs(depth + 1, i );
        }
    }
}
