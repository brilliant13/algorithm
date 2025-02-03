import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Test case 수 입력
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        //x,y좌표 각각 비교
        StringTokenizer st;
        //좌표 2차원배열화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0]) {
                    return e1[1] - e2[1];
                } else {
                    return e1[0] - e2[0];
                }
            }

        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]+" "+arr[i][1]+"\n");
        }
        br.close();
        System.out.println(sb);

    }
}