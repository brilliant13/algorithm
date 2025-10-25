import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //이게왜 탐욕적. 그리디인가?
    //순간순간 최적을 구하고, 가장 이상적이게 출발해서 최적해를 구하니까.
    //최소 테이프길이가 필요하면, 최대한 적은 테이프개수로 많은걸 메꾸면 된다. 가장왼쪽(0)부터 진행하면서 테이프를 최적으로 붙여본다.
    public static void main(String[] args) throws IOException {
        //4:40
        //가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샌다
        //물이 새는 곳의 위치, 항승이의 테이프 길이 L
        //항승이가 필요한 테이프의 최소 개수는?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1<= N,L <=1000 자연수
        // 1<= 물이 새는 곳의 위치 <=1000  자연수
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        //  0.5 1 1.5 = 1cm필요
        // 1.5 2 2.5 = 1cm필요

        //테이프길이 N
        // 1 ~ 1+ (N-0.5)
        // 2가 N-0.5보다 작으면 포함됨. 그 구간에 있으면
        //즉 1 ~ 1+(N-1)
        //정렬하고 앞에서부터 뒤로최대한 길게 붙이면 되지않나. 테이프 가장 적게 쓸 거니까.

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //1 2 5 7 9 100 101

        int count =1;
        int range = arr[0] + (L - 1);

        for (int i = 1; i < arr.length; i++) {
            //범위에 포함되면 넘어감
            if(range >= arr[i]) continue;
            //범위 포함안되면 새 테이프 가져온다.
            count++;
            range = arr[i] + (L - 1);
        }
        System.out.println(count);
    }
}

