import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;

    static boolean[][] visited;
    static int[][] map;
    static int[][] group;
    static int groupNum;
    static Map<Integer, Integer> groupMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        map = new int[N + 1][M + 1]; //1-based
        visited = new boolean[N + 1][M + 1]; //1-based

        group = new int[N + 1][M + 1]; //1-based
        //디폴트 = -1 (그룹 없음)
        for (int[] g : group) {
            Arrays.fill(g, -1);
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            String nums = br.readLine();
            for (int j = 1; j <= M; j++) {
//                map[i][j] = Integer.parseInt(nums.charAt(j - 1) + "");
                map[i][j] = nums.charAt(j - 1) - '0'; //char -> int
            }
        }

        //그룹 계산
        groupMap = new HashMap<>();
        groupNum = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (map[i][j] == 1) continue;

                    groupNum++;
                    group[i][j] = groupNum;
                    bfs(i, j);
                }
            }
        }

        //벽 부수고 이동하기
        for (boolean[] vis : visited) {
            Arrays.fill(vis, false);
        }

        int[][] answer = new int[N][M]; //정답은 0-based

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                if (map[i][j] == 0) {
                    answer[i - 1][j - 1] = 0;
                    continue;
                }

                int count = 1;
                HashSet<Integer> seen = new HashSet<>(4);

                //그룹이 없으면 벽 자체만(자기자신) 카운트 (=1)
                //상하좌우 이동해서 그룹 존재하는지 확인
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx <= 0 || nx > N || ny <= 0 || ny > M) continue;

                    int gid = group[nx][ny];
                    //주변 그룹 없으면 자신만 카운트
                    if (gid != -1 && seen.add(gid)) {
                        count += groupMap.get(group[nx][ny]);
                    }
                }
                answer[i - 1][j - 1] = count%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ans : answer) {
            for (int an : ans) {
                sb.append(an);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void bfs(int row, int col) {
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx <= 0 || nx > N || ny <= 0 || ny > M) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 1) {
                        //벽이면 종료
                        continue;
                    }
                    count++;
                    group[nx][ny] = groupNum;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        groupMap.put(groupNum, count);
    }
}


