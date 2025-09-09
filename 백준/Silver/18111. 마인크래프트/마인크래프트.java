import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

//        int leastTime = Integer.MAX_VALUE;
//        int height = 0;

        int[][] map = new int[N][M];
        int minH = 256, maxH =0; //입력 케이스, 실제 최소, 최대

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                if(v<minH) minH = v;
                if(v>maxH) maxH = v;
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestH = -1;

//        Map<Integer, Integer> timeBox = new HashMap<>();

        for (int h = minH; h <= maxH; h++) { //BruteForce
            long remove =0, add =0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int v = map[i][j];
                    if(v>h) remove += (v - h);
                    else add += (h - v);
                }
            }
            if (add <= B + remove) {
                int time = (int) (2 * remove + add);
                if (time < bestTime || (time == bestTime && h > bestH)) {
                    bestTime = time;
                    bestH = h;
                }
            }
        }

        System.out.println(bestTime + " " + bestH);


    }
}
