import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] list,seq;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M]; //0..M-1

        st = new StringTokenizer(br.readLine());

        list = new int[N];
        for (int i = 0; i < N; i++) list[i] = Integer.parseInt(st.nextToken());
        // 9 1 7 9
        Arrays.sort(list);
        // 1 7 9 9

        //in-place unique
        int k = 0;
        for (int i = 0; i < N; i++) {
            if(i==0 || list[i] != list[i-1]) list[k++] = list[i];
        }
        N = k; //k는 중복되지 않는 원소 수
//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }
//        System.out.println("k개 복사 후 ========= ");

        list = Arrays.copyOf(list, k);

//        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
//        }





        //int[] -> IntStream -> 중복삭제, 정렬 -> int[]
//        list = Arrays.stream(list).distinct().sorted().toArray();
//        N = list.length;

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) { //입력으로 중복값이 들어올 수도 있는, 중복순열 완성
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append((i + 1) == M ? '\n' : ' ');
            }
            return;
        }
        for (int i = 0; i < N; i++) { // 1 7 9
            seq[depth] = list[i];
            dfs(depth + 1);
        }
    }


}
