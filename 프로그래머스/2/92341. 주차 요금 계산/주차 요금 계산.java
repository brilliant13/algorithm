import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];

        // 차량번호 -> 시각 기록(분)
        Map<Integer, List<Integer>> carTimeList = new HashMap<>();

        for (String rec : records) {
            String[] parts = rec.split(" ");
            int car = Integer.parseInt(parts[1]);

            int h = Integer.parseInt(parts[0].substring(0, 2));
            int m = Integer.parseInt(parts[0].substring(3));
            int t = h * 60 + m;

            carTimeList.computeIfAbsent(car, k -> new ArrayList<>()).add(t);
        }

        // 차량번호 -> 최종 요금
        Map<Integer, Integer> carFeeList = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> e : carTimeList.entrySet()) {
            int car = e.getKey();
            List<Integer> times = e.getValue();

            // OUT 없으면 23:59 추가
            if (times.size() % 2 != 0) times.add(23 * 60 + 59);

            // 총 주차시간
            int total = 0;
            for (int i = 0; i < times.size(); i += 2) {
                total += times.get(i + 1) - times.get(i);
            }

            // 요금 계산 (한 번만)
            int fee;
            if (total <= baseTime) {
                fee = baseFee;
            } else {
                int extra = total - baseTime;
                int units = (extra + unitTime - 1) / unitTime; // ceil(extra/unitTime)
                fee = baseFee + units * unitFee;
            }
            carFeeList.put(car, fee);
        }

        // 차량번호 오름차순 결과
        List<Integer> carList = new ArrayList<>(carFeeList.keySet());
        Collections.sort(carList);

        return carList.stream()
                      .map(carFeeList::get)
                      .mapToInt(Integer::intValue)
                      .toArray();
    }
}
