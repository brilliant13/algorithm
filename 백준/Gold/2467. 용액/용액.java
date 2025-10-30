import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //산선 용액과 알칼리성 용액을 보유하고 있다.
        //각 용액에는 특성을 나타내는 하나의 정수가 주어져 있다.
        //산성 용액 : 1 ~ 1,000,000,000(10억) 양의 정수
        //알칼리성 용액 : -1 ~ -1,000,000,000(-10억) 까지의 음의 정수
        //두 용액 섞어서 특성값 합한 뒤 0에 가장 가까운 용액을 만들려고 한다.
        //둘 다 산성 또는 알칼리만으로 혼합 용액 만드는 경우도 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] list = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //오름차순으로 입력됨
        //-99 -2 -1 4 98
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        long[] ans = new long[2];
        long optimal = Long.MAX_VALUE;


        //최소면 갱신해서 들고다닌다.
        // 0보다 작다면 0으로 향하기 위해서 오른쪽 포인터를 늘리고
        // 0보다 크다면 0으로 향하기 위해서 왼쪽 포인터를 낮추고
        // 0이면 더할 나위없이 좋으니까 뽑아주고
        //그럼 r포인터 최대 십만번이고, l도 최대 십만번.
        //
        //전체경우를 다 안바도 되는 이유는 무엇일까? 두 포인터로 최대 한번씩만 훑어도 되는 이유는? 완탐에 비교해서 빠뜨려지는 경우는 없나?
        //그럼 이건 그리디인가?


        int r = 0, l = N - 1;
        while (r < l) {
            long cur = list[r] + list[l];

            if (cur == 0) {
                System.out.println(list[r] + " " + list[l]);
                return;
            }

            //절댓값이 작다. 답의 후보가 된다.
            if (Math.abs(optimal) > Math.abs(cur)) {
                optimal = cur;
                ans[0] = list[r];
                ans[1] = list[l];
            }

            if (cur <0) { //0보다 작다면 r포인터 늘려서 크게만들고
                r++;
            } else { //0보다 크다면 l포인터 내려서작게만들어야지
                l--;
            }

        }
//        System.out.println("r = " + r);
//        System.out.println("l = " + l);
        System.out.println(ans[0] + " " + ans[1]);




    }
}

