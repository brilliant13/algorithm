import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로 (y)
        int N = Integer.parseInt(st.nextToken()); // 세로 (x)
        int H = Integer.parseInt(st.nextToken()); // 높이 (z)

        // tomatoes[x][y][z]: -1(빈칸), 0(안익음), 1(처음부터 익음), 2..(익은 날+1)
        int[][][] tomatoes = new int[N][M][H];
        Queue<int[]> q = new ArrayDeque<>();

        // 입력 & 초기 큐 적재(익은 토마토들)
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    int t = Integer.parseInt(st.nextToken());
                    tomatoes[x][y][z] = t;
                    if (t == 1) q.offer(new int[]{x, y, z}); // 1은 그대로 두고 시작
                }
            }
        }

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        // BFS: 0(안 익음)만 전파하여 현재값+1로 기록
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], z = cur[2];

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d], ny = y + dy[d], nz = z + dz[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if (tomatoes[nx][ny][nz] != 0) continue;          // 0만 익힐 수 있음

                tomatoes[nx][ny][nz] = tomatoes[x][y][z] + 1;      // 날짜(거리) 누적
                q.offer(new int[]{nx, ny, nz});
            }
        }

        // 결과 계산: 0 남아있으면 -1, 아니면 (최대값 - 1)
        int max = 1;
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    int v = tomatoes[x][y][z];
                    if (v == 0) { // 끝까지 안 익은 칸 존재
                        System.out.println(-1);
                        return;
                    }
                    if (v > max) max = v;
                }
            }
        }
        System.out.println(max - 1); // 총 소요일
    }
}
