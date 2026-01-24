import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static final long INF = Long.MAX_VALUE;
    static long distance[];
    static Edge edges[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            //지점의 수
            edges = new Edge[2 * M + W]; //0-based
            distance = new long[N + 1]; //1-based


            //도로
            for (int i = 0; i < 2 * M; ) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(S, E, T);
                edges[i + 1] = new Edge(E, S, T);
                i = i + 2;
            }

            //웜홀
            for (int j = 2 * M; j < 2 * M + W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[j] = new Edge(S, E, -T);
            }

            //음의 사이클이 있는지 확인 (벨만포드 알고리즘)
            //N개의 시작점
            boolean myCycle = false;

            out:
            for (int p = 1; p <= N; p++) {
                //거리배열 초기화
                Arrays.fill(distance, INF);
                //시작점 거리 = 0
                distance[p] = 0;
                boolean update = false;

                //다음 Round (N-1번 라운드까지 진행)
                for (int i = 0; i < N; i++) {
                    update = false;
                    for (int k = 0; k < 2 * M + W; k++) {
                        Edge edge = edges[k];
                        // u->v
                        if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.cost) {
                            distance[edge.end] = distance[edge.start] + edge.cost;
                            update = true;
                        }
                    }
                    //갱신이 없다면 추가 갱신가능성이 없으니 pass
                    if (!update) {
                        continue out;
                    }
                }
                //N-1라운드 후 음의 사이클 체크
                for (int k = 0; k < 2 * M + W; k++) {
                    Edge edge = edges[k];
                    //시작점에서 도달할 수 없는 정점은 pass하고,
                    if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.cost) {
                        myCycle = true;
                        sb.append("YES").append('\n');
                        break;
                    }
                }
                if (myCycle) break;
            }

            if (!myCycle) sb.append("NO").append('\n');
        }
        System.out.print(sb);
    }
}


