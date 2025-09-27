import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //산성 용액 vs 알칼리성 용액
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        //[-99, -4, -2, -1, 98]
        int l = 0, r = N - 1;
        int bestAbs = Integer.MAX_VALUE;
        int ansL = nums[l], ansR = nums[r];

        while (l < r) {
            int sum = nums[l] + nums[r];
            int abs = Math.abs(sum);
            if (abs < bestAbs) {
                bestAbs = abs;
                ansL = nums[l];
                ansR = nums[r];
                if (bestAbs == 0) break; //더 이상 개선 불가
            }
            if(sum>0) r--; //합이 양수면 오른쪽 줄이자. +의 영향 줄여야 함.
            else l++; //합이 음수면 왼쪽 늘리자. -의 영향 줄여야 함. 합이 마이너스라는 건 이미 최소가 마이너스라는 뜻이니까.
        }
        //오름차순 출력 보장(정렬 + l<r에서 뽑음)
        System.out.println(ansL + " " + ansR);




    }

}
