class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;

        int di = n - 1; // 배달에서 남은 최외곽 인덱스
        int pi = n - 1; // 수거에서 남은 최외곽 인덱스

        // 뒤에서부터 0(할 일 없음)인 집은 스킵
        while (di >= 0 && deliveries[di] == 0) di--;
        while (pi >= 0 && pickups[pi] == 0)    pi--;

        while (di >= 0 || pi >= 0) {
            // 이번 트립에서 가야 할 최외곽 집(둘 중 더 먼 곳)
            int far = Math.max(di, pi);
            // 왕복 거리 추가 (집 번호는 1부터 시작이므로 +1)
            answer += (long) (far + 1) * 2;

            // 1) 배달: cap 만큼 뒤에서 앞으로 감소
            int load = cap;
            while (di >= 0 && load > 0) {
                if (deliveries[di] == 0) { di--; continue; }
                int use = Math.min(deliveries[di], load);
                deliveries[di] -= use;
                load -= use;
                if (deliveries[di] == 0) di--; // 다 썼으면 다음 유효 집으로
            }

            // 2) 수거: cap 만큼 뒤에서 앞으로 감소
            int take = cap;
            while (pi >= 0 && take > 0) {
                if (pickups[pi] == 0) { pi--; continue; }
                int use = Math.min(pickups[pi], take);
                pickups[pi] -= use;
                take -= use;
                if (pickups[pi] == 0) pi--;
            }

            // 다음 루프 시작 시에도 맨 뒤의 0들은 자동으로 건너뛰게 됨
            while (di >= 0 && deliveries[di] == 0) di--;
            while (pi >= 0 && pickups[pi] == 0)    pi--;
        }

        return answer;
    }
}
