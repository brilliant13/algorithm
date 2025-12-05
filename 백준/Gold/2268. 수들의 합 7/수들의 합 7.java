import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] a; // 원본 배열
    static long[] tree; //Fenwick Tree 배열 (1~N 사용)

    public static void main(String[] args) throws IOException {
        //N개의 수 A[1], A[2], …, A[N] 이 주어졌을 때, 함수 Sum(i, j)는 A[i] + A[i+1] + … + A[j]를 구하는 함수이다. -> 구간  -> 누적합 구하는 펜윅트리(BIT)로 간단하게 구현가능하겠다.
        //Sum함수와 Modify 함수의 사용 목록이 주어졌을 때, 이에 해당하는 연산을 하는 프로그램을 작성하시오

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new long[N + 1]; //1..N
        tree = new long[N + 1]; //1..N

        //처음에는 A[1] = A[2] = … = A[N] = 0이다
        //초기 배열 입력 + Fenwick Tree 초기화
//        for (int i = 1; i <= N; i++) {
//            long value = Long.parseLong(br.readLine());
//            a[i] = value;
//            //처음 한 번은 diff = value (0에서 value로 올리는 느낌) (초기화 중이니까 값이 0이었던 상태에서 value만큼 더해준다.)
//            update(i,value);
//        }

        int queryCount = M;
        while (queryCount-- > 0) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());

            if (type == 1) { //Modify
                //1 t2 t3 : a[t2]를 t3으로 바꾸는 쿼리 (점 갱신)
                int idx = Integer.parseInt(st.nextToken());
                long newValue = Long.parseLong(st.nextToken());

                long diff = newValue - a[idx]; //기존 값과의 차이
                a[idx] = newValue; //원본 배열 갱신
                update(idx, diff); //Fenwick Tree 갱신(Binary Indexed Tree)
            } else if (type == 0) { //Sum
                // 2 t2 t3 : t2 ~ t3까지의 구간 합
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                if (left > right) {
                    int temp = left;
                    left = right;
                    right = temp;
                }

                long result = prefixSum(right) - prefixSum(left - 1);  //누적 합
                sb.append(result).append('\n');
            }
        }
        System.out.print(sb);
    }

    /*
     * A[idx]에 diff를 더해주는 함수
     * (A[idx] += diff 와 같은 효과)
     * 
     */
    static void update(int idx, long diff) {
        while (idx <= N) {
            tree[idx] += diff;
            idx += (idx & -idx); // 마지막 1비트 값만큼 더해서 상위 노드로
        }
    }

    /*
     * A[1] ~ A[idx] 까지의 합 (prefix sum)
     * 
     */
    static long prefixSum(int idx) {
        long sum = 0L;
        while (idx > 0) {
            sum += tree[idx];
            idx -= (idx & -idx); // 마지막 1비트 값만큼 빼서 '조상 노드'로 이동
        }
        return sum;
    }


}
