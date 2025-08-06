import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        int lo = 0, hi = n - 1;
        int bestIdx = n;  // “조건을 만족한 첫 인덱스”를 저장할 변수, 못 찾으면 그대로 n

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;  // >>1 대신 unsigned 쉬프트도 OK
            // mid번 논문부터 n-mid편이 모두 n-mid회 이상 인용됐는가?
            if (citations[mid] >= n - mid) {
                bestIdx = mid;     // 조건 만족 → 후보 저장
                hi = mid - 1;      // 더 왼쪽에 첫 true가 있는지 탐색
            } else {
                lo = mid + 1;      // 거짓이면 오른쪽만 가능
            }
        }

        // bestIdx==n 이면 조건이 한 번도 true가 아니므로 h=0,
        // 그렇지 않으면 h = n - bestIdx
        return bestIdx == n ? 0 : n - bestIdx;
    }
}
