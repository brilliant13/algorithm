import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int M;
    static int best = Integer.MAX_VALUE;
    //선택된 치킨집 표시
    static boolean[] pick;
    //[집][치킨] 맨해튼 거리 미리 계산해놓으면 빠르다
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v==1) houses.add(new int[]{i, j});
                else if(v==2) chickens.add(new int[]{i, j});
            }
        }

        int H = houses.size();
        int C = chickens.size();
        pick = new boolean[C];

        //거리 전처리
        dist = new int[H][C];
        for (int h = 0; h < H; h++) {
            int hx = houses.get(h)[0], hy = houses.get(h)[1];
            for (int c = 0; c < C; c++) {
                int cx = chickens.get(c)[0], cy = chickens.get(c)[1];
                dist[h][c] = Math.abs(hx - cx) + Math.abs(hy - cy);
            }
        }

        //조합(백트랙킹) 시작
        dfs(0, 0);
        System.out.println(best);
    }
    //idx: 현재 고려중인 치킨집 인덱스, picked: 지금까지 선택한 개수
    static void dfs(int idx, int picked) {
        //M개를 다 골랐다면 도시의 치킨 거리(모든 집의 치킨 거리의 합) 계산
        if (picked == M) {
            best = Math.min(best, cityDistance());
            return;
        }
        //남은 치킨집으로 M개를 채울 수 없으면 가지치기
        //idx시점에 아직 보지않은 구간은 [idx, C-1] 따라서,
        //남은 개수 = (C-1)-idx +1 = C - idx
        //지금까지 고른 것(picked)과 남은 개수의 합이 M보다 작다면 더 볼 필요도 없다. 치워 버린다.
        if(idx == chickens.size() || picked +(chickens.size()-idx) < M) return;

        //선택
        pick[idx] = true;
        dfs(idx + 1, picked + 1);

        //미선택(=되돌림 + 다른 가지 탐색)
        pick[idx] = false;
        dfs(idx+1, picked);
    }

    //현재 pick 상태에서 도시 치킨 거리 계산 (빠른 가지치기 포함)
    static int cityDistance() {
        int H = houses.size();
        int C = chickens.size();
        int sum = 0;

        for (int h = 0; h < H; h++) {
            int bestForHouse = Integer.MAX_VALUE;
            for (int c = 0; c < C; c++) {
                if (pick[c]) {
                    bestForHouse = Math.min(bestForHouse, dist[h][c]);
                    //최솟값이 1이면 더 줄어들 수 없으니 살짝 일찍 탈출
                    if(bestForHouse ==1) break;
                }
            }
            sum += bestForHouse;
            if(sum>=best) return sum; //전체 최적보다 커지면 조기 중단
        }
        return sum;
    }
}
