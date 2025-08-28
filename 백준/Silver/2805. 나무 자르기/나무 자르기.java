import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            trees[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees); // 10, 15, 17, 20
        long lo = 0, hi = trees[trees.length - 1];
        long answer = 0;

        while (lo <= hi) {
            long mid = (lo+hi)/2;
            long sum =0;

            for (long tree : trees) {
                if(tree > mid){
                    sum += tree - mid;
                }
            }
            if (sum >= M) { //조건이 만족할 때, 허용범위일 때 답을 임시로 저장해두고 다음 턴 탐색. 가능한 정답 후보 탐색
                lo = mid + 1;
                answer = mid;
            } else {
                hi = mid - 1;
            }

        }
        System.out.println(answer);




    }
}