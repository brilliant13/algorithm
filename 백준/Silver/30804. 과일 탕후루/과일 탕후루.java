import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //긴 막대에 N개의 과일이 꽂혀있다. 과일을 두 종류 이하
        //9종류가능 -> 무조건 두 종류로 처리하기.
        //2종류로 이하로 사용한 탕후루 중에서, 과일의 개수가 가장 많은 탕후루의 과일 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[10]; //과일번호 1..9
        int distinct = 0;
        int ans = 0;

        int l = 0;
        for (int r = 0; r < N; r++) {
            if(cnt[S[r]]++ == 0) distinct++; //새 종류 추가
            while (distinct > 2) { //종류 2초과면 슬라이딩 윈도우. 왼쪽 포인터 줄이기
                if(--cnt[S[l]]==0) distinct--;
                l++;
            }
            ans = Math.max(ans, r - l + 1); //조건 만족 구간길이
        }
        System.out.println(ans);

    }
}
