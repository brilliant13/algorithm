import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        StringTokenizer st;
        //dp배열 들고 다녀도 되긴하는데, 값 갱신하면서 필요한 건 바로 이전 윗 배열이다.
        //바로 이전 배열만 들고다니면서 미끄러지면서 아래로 업데이트한다. 슬라이딩윈도우

        st = new StringTokenizer(br.readLine());
        //첫 줄 초기화
        for (int j = 0; j < 3; j++) {
            int x = Integer.parseInt(st.nextToken());
            maxDp[j] = x;
            minDp[j] = x;
        }
        //2번째 줄부터 N번째 줄까지
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int prevMax0 = maxDp[0];
            int prevMax1 = maxDp[1];
            int prevMax2 = maxDp[2];

            int prevMin0 = minDp[0];
            int prevMin1 = minDp[1];
            int prevMin2 = minDp[2];

            //최대값 갱신
            int newMax0 = Math.max(prevMax0, prevMax1) + a;
            int newMax1 = Math.max(Math.max(prevMax0, prevMax1),prevMax2) + b;
            int newMax2 = Math.max(prevMax1, prevMax2) + c;

            //최솟값 갱신
            int newMin0 = Math.min(prevMin0, prevMin1) + a;
            int newMin1 = Math.min(Math.min(prevMin0, prevMin1),prevMin2) + b;
            int newMin2 = Math.min(prevMin1, prevMin2) + c;

            maxDp[0] = newMax0;
            maxDp[1] = newMax1;
            maxDp[2] = newMax2;

            minDp[0] = newMin0;
            minDp[1] = newMin1;
            minDp[2] = newMin2;
        }

        int maxAns = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int minAns = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.print(maxAns + " " + minAns);

    }

}
