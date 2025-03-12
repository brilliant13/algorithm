import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited [];
    static int result [] ;

    public static void main(String[] args) throws IOException {
    //너비우선탐색(BFS)
    //인접 정점은 내림차순으로 방문.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a); //양방향
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        bfs(start, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int start, int N) {
        int cnt = 1;
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]= true;
        result[start] = cnt++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int num : list.get(cur)) {
                if (!visited[num]) {
                    queue.add(num);
                    visited[num]=true;
                    result[num] = cnt++;
                }
            }
        }
    }

}
