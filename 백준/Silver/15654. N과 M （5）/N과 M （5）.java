import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static boolean[] used; // 인덱스 기반 사용 여부 (길이 N)
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
        used = new boolean[N]; // ★ 값이 아니라 '인덱스'로 체크
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) { //순열 구성 끝
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1 == M) ? '\n' : ' ');
            }
            return;
        }
        for (int num = 0; num < N; num++) { //정렬된 list의 인덱스 순회 -> 사전순
            if(used[num]) continue; //이미 쓴 원소는 건너뛰기
            used[num] = true;
            seq[depth] = list[num]; //실제 값 저장
            dfs(depth + 1);
            used[num] = false; //backtrack
        }
    }
}