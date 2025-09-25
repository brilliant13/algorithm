import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] seq;
    static int[] list;
//    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M]; //0..M-1   0-based
        list = new int[N]; // 0..N-1  0-based
//        used = new boolean[N]; //0..N-1   0-based

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);   // 1 7 8 9

        dfs(0);
        System.out.print(sb);
    }
    static void dfs(int depth) {
        if (depth == M) { //Permutation 완성
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
            return;
        }
//        int start = (depth ==0)? 0 :seq[depth - 1] + 1;
        //연속된 숫자가 아니라, list에 띄엄띄엄 들어가 있는거라서, 인덱스로 접근하기가 좀어렵네. 그럼 used방문처리로 가보자.
        for (int i = 0; i < N; i++) { // 1 7 8 9
            if(depth!=0 && seq[depth-1]>=list[i]) continue;
//            if(used[i])continue;
//            used[i] = true;
            seq[depth] = list[i];
            dfs(depth+1);
//            used[i] = false;
        }
    }
}
