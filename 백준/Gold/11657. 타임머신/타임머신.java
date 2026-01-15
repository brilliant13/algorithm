import java.io.*;
import java.util.ArrayList;
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

    static int N,M;
    static long distance[];
    static Edge edges[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); //최단 거리 배열 초기화하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, cost);
        }
        //벨만-포드 알고리즘 수행 (가중치 음수, 시작점으로부터 최단거리 구하는 알고리즘)
        distance[1] = 0;
        for (int i = 1; i < N; i++) { //정점의 개수-1 만큼 반복하기
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                //더 작은 최단 거리가 있을 때 업데이트하기
                if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.cost) {
                    distance[edge.end] = distance[edge.start] + edge.cost;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < M; i++) {//음수 사이클 확인하기
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.cost) {
                mCycle = true;
            }
        }
        if (!mCycle) {//음수 사이클 없을 때
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    bw.write("-1");
                    bw.newLine();
                } else bw.write(distance[i] + "\n");
            }
        } else {
            bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
    }
}
