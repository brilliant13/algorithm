import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2]; //[i][0] 시작시간, [i][1] 종료시간
        //Greedy사용. 최적 부분 구조.
        //종료시간이 빠른거 정렬하고 순차적으로 뽑으면 끝.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (a,b)->{
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]); //end asc
            return Integer.compare(a[0], b[0]); //start asc (tie-breaker)
        });

        int count = 0;
        int end = 0; //직전 진행 회의 종료시간
        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= end) {
                count++;
                end = meetings[i][1];
            }
        }
        System.out.print(count);
    }
}
