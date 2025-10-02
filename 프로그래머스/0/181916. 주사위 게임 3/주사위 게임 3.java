

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] cnt = new int[7]; // 1..6
        cnt[a]++; cnt[b]++; cnt[c]++; cnt[d]++;

        int kind = 0;
        for (int i = 1; i <= 6; i++) if (cnt[i] > 0) kind++;

        if (kind == 1) { // p p p p
            int p = 0;
            for (int i = 1; i <= 6; i++) if (cnt[i] == 4) { p = i; break; }
            return 1111 * p;
        }

        if (kind == 2) { // p p p q  또는  p p q q
            int p = -1, q = -1;

            // 3+1 인지 먼저 확인
            for (int i = 1; i <= 6; i++) {
                if (cnt[i] == 3) { p = i; break; }
            }
            if (p != -1) {         // p p p q
                for (int i = 1; i <= 6; i++) if (cnt[i] == 1) { q = i; break; }
                int t = 10 * p + q;
                return t * t;      // 정수 제곱 (Math.pow 쓰지 않음)
            } else {               // p p q q
                int x = -1, y = -1;
                for (int i = 1; i <= 6; i++) if (cnt[i] == 2) { if (x == -1) x = i; else y = i; }
                return (x + y) * Math.abs(x - y);
            }
        }

        if (kind == 3) { // p p q r  (값 두 개는 1회씩 등장)
            int prod = 1;
            for (int i = 1; i <= 6; i++) if (cnt[i] == 1) prod *= i;
            return prod;
        }

        // kind == 4 : p q r s → 가장 작은 수
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}

