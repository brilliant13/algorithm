import java.util.*;

class Solution {
        // "HH:MM" -> 분 단위 정수 변환
    private int toMinutes(String hhmm) {
        int h = Integer.parseInt(hhmm.substring(0, 2));
        int m = Integer.parseInt(hhmm.substring(3));
        return h * 60 + m;
    }
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        // 차량번호 0~9999
        int MAX = 10000;
        int[] in_time = new int[MAX];       // 입차 시각(분). 미입차/출차완료 시 -1
        int[] total_time = new int[MAX];    // 누적 주차시간(분)
        boolean[] seen = new boolean[MAX];  // 해당 차량이 등장했는지 (출력대상 판별 및 정렬)
        
        Arrays.fill(in_time, -1);
        
        // 1) 레코드 처리
        for (String rec : records) {
            String[] parts = rec.split(" ");
            int t = toMinutes(parts[0]);
            int car = Integer.parseInt(parts[1]); // "0000"도 0으로 안전히 파싱됨
            String type = parts[2];

            seen[car] = true;

            if (type.equals("IN")) {
                in_time[car] = t; // 입차 시각 기록
            } else { // "OUT"
                // 누적시간 += (출 - 입), 입차 초기화
                total_time[car] += (t - in_time[car]);
                in_time[car] = -1;
            }
        }
        
        
        // 2) 23:59(=1439)까지 출차되지 않은 차량 보정
        for (int car = 0; car < MAX; car++) {
            if (seen[car] && in_time[car] != -1) {
                total_time[car] += (1439 - in_time[car]);
                in_time[car] = -1;
            }
        }
        
        // 3) 등장한 차량 수 집계(정렬은 번호 오름차순이므로 0..9999 순회)
        int count = 0;
        for (int car = 0; car < MAX; car++) {
            if (seen[car]) count++;
        }
        
        int[] answer = new int[count];
        int idx = 0;
        
        // 4) 차량번호 오름차순으로 요금 계산
        for (int car = 0; car < MAX; car++) {
            if (!seen[car]) continue;

            int total = total_time[car];
            // 요금 계산 (총합에 대해 "한 번만")
            int fee;
            if (total <= baseTime) {
                fee = baseFee;
            } else {
                int extra = total - baseTime;
                // ceil(extra / unitTime) == (extra + unitTime - 1) / unitTime
                int units = (extra + unitTime - 1) / unitTime;
                fee = baseFee + units * unitFee;
            }

            answer[idx++] = fee;
        }
        
        return answer;
    }
}