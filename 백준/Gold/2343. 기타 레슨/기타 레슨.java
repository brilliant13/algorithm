import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 강의 수
        int N = Integer.parseInt(st.nextToken());
        // 블루레이 수
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 0-based
        //int total = 0;
        int[] total = new int[N]; // 0-based. 블루레이 크기 후보 배열

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // total += arr[i];
            if (i == 0) {
                total[i] = arr[i];
            } else {
                total[i] += arr[i] + total[i - 1];
            }
        }

        // lo, hi는 인덱스가 아니라 "블루레이 크기 자체"이다. 파라미터 써치라는게 io,hi,mid 자체가 찾으려는 그 값 자체네.
        // lo = 가장 긴 강의 (이보다 작으면 그 강의 자체가 안 들어감) // lo = 9 -> 강의 중 가장 긴 값 -> 블루레이 크기의 하한
        // hi = 전체 강의 합 (블루레이 1개에 다 넣는 경우) // hi = 45 -> 강의 전체 합 -> 블루레이 크기의 상한
        // int[] -> Stream으로 해서 최대최소,합 쉽게 먹기
        int lo = Arrays.stream(arr).max().getAsInt();
        int hi = Arrays.stream(arr).sum();

        while (lo < hi) {
            // 현재 차례에 블루레이 크기라고 가정하고 테스트 하는 변수 mid
            int mid = (lo + hi) >>> 1;

            // 그리디 판정: 블루레이 크기가 mid일 때 몇 개 필요한가?
            // 여왕 개미에서 "mid초일 때 개미 몇 마리가 필요한가?"와 같은 구조이다
            int groups = 1;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (sum + arr[j] > mid) {
                    // 현재 블루레이에 이 강의 넣으면 초과
                    // -> 새 블루레이 시작
                    groups++;
                    sum = arr[j]; // 새 그룹에서 (=새 블루레이에서) start가 arr[j]로 바뀌는 것이다.
                } else {
                    sum += arr[j];
                }
            }

            // 이번 차례 mid 변수의 판정 결과로 범위 조정한다.
            if (groups <= M) {
                // 그룹을 늘려도 된다. 블루레이 크기 자체를 줄이면 그룹수가 증가한다.
                // 가능 -> 더 작은 크기를 시도.
                hi = mid;
            } else { //groups > M
                // 그룹을 더 줄여야 한다.
                // 불가능 -> 크기 늘려야 함.
                lo = mid + 1;
            }
        }
        System.out.print(lo);


        // <----- ------------ ------------ ------------ ------->
        // total 배열에서 이분 탐색 해야 되는 것 같다. arr에서 이분탐색하는 게 아니지.


//        //Arrays.sort(total); 어차피 순차적으로 더하니까 정렬 안해도 되네
//
//        // Parametric Search (이분탐색 활용 2)
//        // 판정함수(mid)에서 매개변수 mid 갱신해가면서 하한경계찾기
//        // mid = 이번 타임에서 체크할 블루레이 크기
//        // int lo = 0, hi = N - 1; //누가 total 배열 크기가 N-1이래? 1~최대 사이니까 최대값이 크기아닌가?
//        int lo = 0, hi = total.length;
//        // 크기가 같은 M개의 그룹 //판정결과에 따라 groups 수치올려가면서 나중에 판정 결과로 범위 조정
//
//        while (lo < hi) {
//            // 적정한 블루레이 크기 값을 이분탐색을 이용해 찾는다. (Parameter Search)
//            int mid = (lo + hi) >>> 1; // 가능한 블루레이 전체 크기 1 ~ total
//
//            // lo,hi는 인덱스. 값은 arr[index]로 읽는다.
//            //if (arr[mid] * M >= total) {
//            if (total[mid] * M >= total[N - 1]) {
//                // 블루레이 크기 * M(총 개수)가 전체 용량보다 크니까 블루레이 크기(=mid) 더 줄이는 시도 해도 좋다.
//                hi = mid;
//            } else {
//                // 블루레이 크기 * M(총 개수)가 전체 용량보다 작다면, 블루레이 크기를 늘려야 한다. M은 고정값이니까.
//                // lo = mid +1; 헉. mid-1인데 +1 실수했다..
//                lo = mid + 1;
//            }
//        }
//        // 탐색 끝 (lo==hi). 주어진 총 개수(=M) 상황에서 크기 mid의 하한선을 찾은 것이다.
//        // System.out.print(lo); 헉. lo는 인덱스인데 인덱스만 출력하는 실수를 했다.
//        //System.out.print(arr[lo]);
//
//        // 가능한 블루레이의 크기 중 최소를 구하세요.
//        System.out.print(total[lo]);
    }
}
