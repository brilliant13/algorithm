import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int M;
    static int[][]dist; //[집][치킨] 도시블록거리(맨해튼거리)
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 입력: 0=빈칸, 1=집, 2=치킨집
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if(v==1) houses.add(new int[]{i, j});
                else if(v==2) chickens.add(new int[]{i, j});
            }
        }

        int H = houses.size();
        int C = chickens.size();

        //거리 전처리
        dist = new int[H][C];
        for (int h = 0; h < H; h++) {
            int hx = houses.get(h)[0], hy = houses.get(h)[1];
            for (int c = 0; c < C; c++) {
                int cx = chickens.get(c)[0], cy = chickens.get(c)[1];
                dist[h][c] = Math.abs(hx - cx) + Math.abs(hy - cy);
            }
        }

        int best = INF;

        // 치킨집 C개에 대해 0..(1<<C)-1 모든 부분집합 마스크 순회.  2^c개의 경우의 수. 치킨집 하나당 올수도 있고, 안 올 수도 있고 경우의 수 2개. 곱의 법칙.
        // 그중에서 popcount ==M (정확히 M개 선택)만 사용 -> 백트랙킹으로도 가능.
        for (int mask = 0; mask < (1 << C); mask++) {
            //mask 하나당 -> 치킨집을 M개 고르는 하나의 경우의 수. (C Combination M)
            if(Integer.bitCount(mask)!=M) continue; //0~ 2^c-1  까지 증가시키면서, 마스킹 체크 중 M개가 아닌 건 건너뛴다.

            int sum =0;
            // 도시 치킨 거리 계산: 각 집마다 선택된 치킨집까지의 최단 거리 합
            for (int h = 0; h < H; h++) {
                int bestForHouse = INF;
                for (int c = 0; c < C; c++) {
                    if ((mask & (1 << c)) != 0) {//선택된 치킨집인가?
                        int d = dist[h][c];
                        if (d < bestForHouse) {
                            bestForHouse = d;
                            if(bestForHouse==1) break; //더 줄 수 없는 최솟값이면 살짝 가지치기
                        }
                    }
                }
                sum += bestForHouse;
                if(sum>=best) break; //전역 최저보다 커지면 조기 중단
            }
            if(sum<best) best =sum; //도시의 치킨거리 갱신여부 판단
        }

        System.out.println(best);
    }
}
