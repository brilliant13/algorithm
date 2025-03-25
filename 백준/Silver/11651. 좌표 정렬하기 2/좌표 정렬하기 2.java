import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        //정렬을 해보자.
        Arrays.sort(array,(a,b)->{
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]); //x좌표 오름차순 정렬
            } else {
                return Integer.compare(a[1],b[1]); //y좌표 오름차순 정렬
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i][0]).append(" ").append(array[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}
