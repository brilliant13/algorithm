import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited[];
    static int result[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수
        int start = Integer.parseInt(st.nextToken()); // 시작 정점

        result = new int[N+ 1];
        for (int i = 0; i <= N; i++) {//1~N 번까지의 부모 ArrayList
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {//간선의 개수만큼 연결리스트에 입력해주기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {// 노드 방문 인접리스트 정렬
            Collections.sort(list.get(i));
        }

        bfs(start, N);
        StringBuilder sb = new StringBuilder();
//        for (int value : result) {
//            sb.append(value).append('\n');
//        }
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);

    }

    private static void bfs(int start, int N) {
        int cnt =1;
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        result[start]=cnt++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int num : list.get(cur)) {
                if (!visited[num]) {
                    queue.add(num);
                    visited[num]=true;
                    result[num]=cnt++;
                }
            }
        }

    }


}
