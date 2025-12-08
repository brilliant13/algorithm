import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] a; // 원본 배열 (실제 값 저장)
    static long[] tree; // Fenwick Tree: 홀수 개수 누적

    public static void main(String[] args) throws IOException {
        //N개의 수 A[1], A[2], …, A[N] 이 주어졌을 때, 구간의 요소들을 업데이트 하거나 수를 출력하라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1) N 입력
        // 에시 : 5
        N = Integer.parseInt(br.readLine());
        a = new long[N + 1]; //1..N
        tree = new long[N + 1]; //1..N

        // 2) 초기 배열 입력 + Fenwick Tree 초기화 (홀수 = 1, 짝수 = 0)
        // 에시 : 1 2 3 4 5
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long value = Long.parseLong(st.nextToken());
            a[i] = value;
        }

        //초기 tree[]는 0으로 초기화 되어있음. k가 추가되는 쿼리가 들어올 떄마다 누적갱신한다.

        // 3) 쿼리 개수 M
        // 에시 : 4
        M = Integer.parseInt(br.readLine());

        // 4) M개의 쿼리 처리
        int queryCount = M;
        while (queryCount-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) { //Modify // 구간 업데이트: 1 i j k
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                // 1 i j k : Ai, Ai+1, ..., Aj에 k를 더한다.

                // [i, j] 구간에 k를 더하기
                // → 차분 배열 관점에서는 B[i] += k, B[j+1] -= k
                // 해당 하는 구역만 k더해주기위해. -> prefixSum(i) = inc[x]가 된다. 누적합이 곧 증가분이 된다.
                // 물론 j+1 <=N일 떄만 고려하는 거다. 구간 마지막끝까지 쿼리들어온거면 뺼 필요 없다.
                rangeAdd(i, j, k);

//                for (int p = i; p <= j; p++) {
//                    //(i ~ j 구간 길이만큼 반복됨)
//                    update(p, k);
//                }
            } else if (type == 2) { //Sum
                // 2 x: Ax 를 출력한다. : 누적합 A[x] = prefixSum(x) - prefixSum(x-1) 뺴기로 구한다.
                int x = Integer.parseInt(st.nextToken());

                //지금까지 x에 더해진 값 = prefixSum(x)
                long added = prefixSum(x);
                long ans = a[x] + added; // 초기값 + 누적 추가분
                sb.append(ans).append('\n');
            }
        }
        System.out.print(sb);
    }

    // [i, j] 구간에 k를 더하는 함수 (O(logN))
    static void rangeAdd(int i, int j, long k) {
        update(i, k); // i부터 끝까지 +k
        if (j + 1 <= N) {
            update(j + 1, -k); // j+1부터 끝까지 -k
        }
    }

    // Fenwick Tree: B[idx]에 diff를 더해주는 함수
    static void update(int idx, long diff) {
        while (idx <= N) {
            tree[idx] += diff;
            idx += (idx & -idx); // 마지막 1비트 값만큼 더해서 상위 노드로
        }
    }

    // Fenwick Tree: B[1] ~ B[idx] 까지의 합 = A[idx]에 더해진 누적 값
    static long prefixSum(int idx) {
        long sum = 0L;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx); // 마지막 1비트 값만큼 빼서 '조상 노드'로 이동
        }
        return sum;
    }



}
