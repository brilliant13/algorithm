

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력: 행렬의 크기 N ,M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //입력: NxM 행렬 입력
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
//        for (int i = 0; i < 2*N; i++) {
//            st = new StringTokenizer(br.readLine());
//        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //행렬 덧셈
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write((A[i][j] + B[i][j])+" ");
            }
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();

    }
}



