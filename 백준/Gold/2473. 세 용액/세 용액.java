import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다.
        // 산성 용액 : 1~ 1,000,000,000
        // 알칼리성 용액 : -1~-1,000,000,000
        // 같은 양의 세 가지 용액을 혼합한 용액의 특성값 = 각 용액의 특성값의 합
        // 세 가지 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 용액 개수 입력
        int N = Integer.parseInt(br.readLine());
        //2. 용액 특성값 입력
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        //3. 투 포이넡를 사용하기 위해 정렬
        Arrays.sort(arr);

        //bestAbs : 지금까지 찾은 "0과의 거리(절댓값)" 중 최소값
        long bestAbs = Long.MAX_VALUE;

        //정답으로 선택된 세 용액 값을 저장할 변수
        long answer1 = 0;
        long answer2 = 0;
        long answer3 = 0;

        //4. 첫 번쨰 용액을 하나씩 고정
        // 세 개를 골라야 하므로 i는 N-3까지 가능하다
        for (int i = 0; i < N - 2; i++) {
            //i를 첫 번째 용액으로 고정했을 때,
            //2번째,3번째 용액은 i뒤쪽에서 투 포인터로 찾자
            int left = i + 1;
            int right = N - 1;

            //left와 right가 겹치기 전까지 탐색
            while (left < right) {
                //현재 선택된 세 용액의 합
                long sum = arr[i] + arr[left] + arr[right];

                //0과 얼마나 가까운지 보기 위해 절댓값 계산
                long absSum = Math.abs(sum);

                //지금까지 찾은 최솟값보다 더 0에 가까우면 정답 갱신
                if (absSum < bestAbs) {
                    bestAbs = absSum;
                    answer1 = arr[i];
                    answer2 = arr[left];
                    answer3 = arr[right];
                }

                //합이 0보다 작다는 뜻은 값이 너무 작다는 뜻
                //정렬된 상태니까, left를 오른쪽으로 한 칸 이동해서 더 좋은 후보가 있는지 try 해 볼 수 있다.
                //=> 더 큰 값을 만들기 위해 left를 오른쪽으로 이동한다. 물론 깂이 커지지만 절댓값이 기존보다 커져버리면 갱신하지 않는다.
                if (sum < 0) {
                    left++;
                }
                //합이 0보다 크다는 뜻은 값이 너무 크다는 뜻
                //=> 더 작은 값을 만들기 위해 right를 왼쪽으로 이동한다. 물론 값이 작아지지만 절댓값이 기존보다 커져버리도록 크게 작아지면 갱신하지 않는다.
                else if (sum > 0) {
                    right--;
                }
                //합이 정확히 0이면 더 이상 볼 필요 없는 최적해!
                else {
                    System.out.println(answer1 + " " + answer2 + " " + answer3 + " ");
                    return;
                }
            }
        }

        //문제에서 오름차 순으로 출력하라고 함.
        //arr을 정렬한 뒤 i < left < right 순서로 뽑았으므로
        //answer1 <= answer2 <= answer3 가 항상 성립한다.
        System.out.println(answer1 + " " + answer2 + " " + answer3 + " ");
    }
}
