import java.io.*;

/**
 * BOJ 2108 〈통계학〉
 * - 입력 값:  N(홀수) ≤ 500 000,  각 숫자 |x| ≤ 4 000
 * - 출력: 산술평균, 중앙값, 최빈값(2번째로 작은 값), 범위
 * <p>
 * 핵심 아이디어
 * ① 값 범위가 작다 (-4000~4000) → cnt[8001] 계수 정렬 사용
 * ② sum·min·max 를 입력과 동시에 누적 / 갱신
 * ③ 중앙값·최빈값은 cnt 배열을 한 번 또는 두 번 스캔해 추출
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 항상 홀수

        int[] freq = new int[8001];                     // idx 0 ↔ -4000, idx 8000 ↔ +4000
        long sum = 0;                                 // 산술평균용 (long: 오버플로 방지)
        int minVal = 4001;                              // 범위용 (초기값은 최대+1)
        int maxVal = -4001;

        /* ---------- 1) 입력 & 빈도 집계 ---------- */
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(br.readLine());
            sum += v;
            freq[v + 4000]++;                           // 값 → 빈도 배열
            if (v < minVal) minVal = v;
            if (v > maxVal) maxVal = v;
        }

        /* ---------- 2) 산술평균 ---------- */
        int mean = (int) Math.round(sum / (double) N);

        /* ---------- 3) 중앙값 ---------- */
        int median = 0;
        int count = 0;                                 // 누적 개수
        int target = (N + 1) / 2;                       // 중앙 위치 (N은 홀수)

        for (int i = 0; i < freq.length; i++) {
            count += freq[i];
            if (count >= target) {                      // 처음으로 누적 ≥ 중앙 위치
                median = i - 4000;                      // 인덱스 → 실제 값
                break;
            }
        }

        /* ---------- 4) 최빈값 (두 번째로 작은 값) ---------- */
        int maxFreq = 0;
        for (int f : freq) maxFreq = Math.max(maxFreq, f);

        int mode = 0;
        int modeCount = 0;                              // 몇 번째 최빈값인지 카운트
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {                   // 최빈값 후보
                mode = i - 4000;
                if (++modeCount == 2) break;            // 두 번째면 확정
            }
        }

        /* ---------- 5) 범위 ---------- */
        int range = maxVal - minVal;

        /* ---------- 6) 출력 ---------- */
        StringBuilder sb = new StringBuilder();
        sb.append(mean).append('\n')
                .append(median).append('\n')
                .append(mode).append('\n')
                .append(range);

        System.out.println(sb);
    }
}
