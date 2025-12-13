import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        visited = new boolean[1_000_000_001];// 1~10^9

        //A->B
        //2를 곱한다
        //1을 수의 가장 오른쪽에 추가한다
        //A->B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
        //그냥 최단거리네. 그래프 최단거리 -> BFS
        //최소레벨 세면서 찾으면 답내면 된다.

        //입력값 10억이하
        System.out.println(bfs(A, B));
    }

    static int bfs(int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;
        boolean find = false;


        while (!q.isEmpty()) {
            int qsize = q.size();
            count++;

            for (int i = 0; i < qsize; i++) {
                int cur = q.poll();
                long first = cur*2L;
                long second = cur*10L +1;

                if (first == end || second ==end) {
                    return count + 1;
                }
                if (first <= end && !visited[(int)first]) {
                    visited[(int) first] = true;
                    q.offer((int) first);
                }
                if (second <= end && !visited[(int) second]) {
                    visited[(int) second] = true;
                    q.offer((int) second);
                }
            }
        }
        return -1;
    }
}
