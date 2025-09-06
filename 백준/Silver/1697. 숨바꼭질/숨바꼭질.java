import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        final int MAX = 100000;

        int depth = 0;
        boolean[] visited = new boolean[MAX + 1]; // 1~100000
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == K) {
                    System.out.print(depth);
                    return;
                }
                int[] nexts = {cur - 1, cur + 1, cur * 2};
                for (int nx : nexts) {
                    if (0 <= nx && nx <= MAX && !visited[nx]) {
                        visited[nx] = true;
                        q.add(nx);
                    }
                }
            }
            depth++;
            //큐에서 꺼내고, 찾는 값 아니면 아래층으로 이동. depth ++
        }
    }
}