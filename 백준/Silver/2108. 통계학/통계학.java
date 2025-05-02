import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; // 0~N-1
        //계수정렬
        int [] cnt = new int[8001]; // 0~8000 0~4000 ( -4000~ 0 ), 4001~8000 ( 1 ~ 4000 )
        int sum =0;


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //1입력
            sum += arr[i];
            cnt[arr[i]+4000]++; // 1+4000 => 4001 요소에 카운트
        }

        StringBuilder sb = new StringBuilder();

        int a = 0, b = 0, c = 0, d = 0;
        Arrays.sort(arr); //sort할 때 0이들어가니까 이게 맨 앞으로가지 음수일떄는..

        //1. 산술평균
        //정수 단위로 반올림
        sb.append(Math.round((double)sum/N)).append('\n');

        //2. 중앙값  //

        sb.append(arr[N/2]).append('\n');


        //3. 최빈값
        int maxFreq = 0;
        for (int f : cnt) maxFreq = Math.max(maxFreq, f);

        int mode =0, modeCount=0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == maxFreq) {
                mode = i - 4000;
                if(++modeCount ==2 ) break;
            }
        }
        sb.append(mode).append('\n');


        //4. 범위
        sb.append(arr[N-1]-arr[0]);

        System.out.println(sb);

    }
}

