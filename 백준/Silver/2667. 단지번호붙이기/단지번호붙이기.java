import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb;
    static int totalCount = 0;
    static int count = 0;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(),"");
            String[] strs = br.readLine().split("");
            int idx = 0;
            for (int j = 0; j < strs.length; j++) {
                map[i][idx++] = Integer.parseInt(strs[j]);
            }
        }
        sb = new StringBuilder();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count =0;
                    bfs(i, j);
                    list.add(count);
                    totalCount++;
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(totalCount);
        for (int num : list)System.out.println(num);

    }

    private static void bfs(int i, int j) {
        //bfs 메소드 안에는 오직 큐를 이용한 탐색(While문)만 있다.
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y =cur[1];
            count++;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if(nx<0 || nx>= N || ny <0 || ny>=N) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}