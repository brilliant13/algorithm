import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄 입력 (N, X)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 두 번째 줄 입력 (수열 A)
        st = new StringTokenizer(br.readLine()); //  같은 변수 `st`를 재사용

        //배열 사용하지 않고 바로 출력 (메모리절약)
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num < X) {
                bw.write(num+" ");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}


