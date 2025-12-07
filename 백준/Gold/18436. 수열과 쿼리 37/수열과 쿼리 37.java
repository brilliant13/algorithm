import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a;      // 원본 배열 (실제 값 저장)
    static int[] tree;   // Fenwick Tree: 홀수 개수 누적

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1) N 입력
        N = Integer.parseInt(br.readLine());
        a = new int[N + 1];     // 1..N
        tree = new int[N + 1];  // 1..N

        // 2) 초기 배열 입력 + Fenwick Tree 초기화 (홀수 = 1, 짝수 = 0)
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            a[i] = value;
            int parity = value & 1;  // 홀수면 1, 짝수면 0
            update(i, parity);       // 처음 상태는 0에서 parity로 올리는 느낌
        }

        // 3) 쿼리 개수 M
        M = Integer.parseInt(br.readLine());

        // 4) M개의 쿼리 처리
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (type == 1) {
                // 1 b c : A[b]를 c로 변경
                int oldParity = a[b] & 1;
                int newParity = c & 1;
                int diff = newParity - oldParity;   // -1, 0, 1

                if (diff != 0) {
                    update(b, diff);
                }
                a[b] = c; // 원본 값 갱신

            } else if (type == 2) {
                // 2 b c : [b, c] 구간의 짝수 개수
                int oddCount = rangeSum(b, c);
                int len = c - b + 1;
                int evenCount = len - oddCount;
                sb.append(evenCount).append('\n');

            } else if (type == 3) {
                // 3 b c : [b, c] 구간의 홀수 개수
                int oddCount = rangeSum(b, c);
                sb.append(oddCount).append('\n');
            }
        }

        System.out.print(sb);
    }

    // Fenwick Tree: A[idx]에 diff를 더해주는 함수 (여기선 홀수 개수 변화량)
    static void update(int idx, int diff) {
        while (idx <= N) {
            tree[idx] += diff;
            idx += (idx & -idx); // 마지막 1비트만큼 더해서 상위 노드로
        }
    }

    // Fenwick Tree: A[1] ~ A[idx] 까지의 홀수 개수 합
    static int prefixSum(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx); // 마지막 1비트만큼 빼서 조상 노드로
        }
        return sum;
    }

    // 구간 [l, r]의 홀수 개수
    static int rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
    }
}
