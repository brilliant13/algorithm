import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //2차원 평면상에 N개의 점으로 이루어진 다각형이 있다. 이 다각형의 면적을 구하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[] figure1 = new long[N + 1];
        long[] figure2 = new long[N + 1]; //0..N


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            figure1[i] = x;
            figure2[i] = y;
        }

        figure1[N] = figure1[0];
        figure2[N] = figure2[0];

        //1/2 | | 공식 사용
        double area = 0;
        for (int i = 0; i < N; i++) {
            long A = figure1[i] * figure2[i + 1];
            long B = figure2[i]*figure1[i + 1];
            area += A-B;
        }

        area = Math.abs(area / 2.0);

        System.out.printf("%.1f", area);



    }
}
