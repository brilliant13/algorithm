import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static long[] tree;
    static final long MOD =1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //트리 사이즈 구하기
        int length = 1;
        int treeHeight = 0;
        while (length < N) {
            length <<= 1;
            treeHeight++;
        }

        int treeSize = 1 << (treeHeight + 1);
        tree = new long[treeSize]; //0..15
        for (int i = 1; i < treeSize; i++) {
            tree[i] = 1L;  // 곱의 항등원
        }

        int leftNodeStartIndex = (1 << treeHeight) - 1; //2^h부터 주어진 구간값들 채워넣음

        for (int i = 1; i <= N; i++) {
            tree[leftNodeStartIndex + i] = Long.parseLong(br.readLine());
        }

        //트리만들기 ( 세그먼트 트리 채우기 ). 구간합으로.
        setTree(treeSize - 1);

        //쿼리 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(leftNodeStartIndex + s, e);
            } else if (a == 2) {
                s = s + leftNodeStartIndex;  // s + (2^h) - 1
                e = e + leftNodeStartIndex;
                sb.append(getMul(s, (int) e) + "\n");
            } else {
                return;
            }
        }
        System.out.print(sb);

    }

    private static long getMul(int s, int e) { //구간 합을 구하는 함수
        long partMul = 1; //부분곱
        while (s <= e) {
            if (s % 2 == 1) {//홀수 인덱스면 선택 후 +1 //선택한다는 건 부분합에 더해준다는 말이다.
                partMul = (partMul * tree[s]) % MOD;
                s++;
            }
            if (e % 2 == 0) { //짝수 인덱스면 선택 후 -1.
                partMul = (partMul * tree[e]) % MOD;
                e--;
            }
            //e가 짝수인덱스면 -1, 홀수 인덱스면 가만히 둔다. => 홀수 인덱스일 경우에는 -1을 해고 부모로 올라가도 원래 부모다.
            //짝수 인덱스일 경우에는 -1을 하고 부모로 올라가면 원래 자신의 부모가 아니라, 이전 노드의 부모다.
            //endIdx가 짝수번인데 그냥 부모로 올라가면, endIdx의 직후의 노드의 값까지 부분합으로 더해진 부모가 더해진다.
            //그래서 endIdx를 더해주고, -1시켜서 이전 노드들의 합을 부분합으로 갖는 부모노드로 올라가는 것이다.

            //부모로 올라가자
            s /=2;
            e /=2;
        }
        return partMul%MOD;
    }

    private static void changeVal(int index, long val) {
        //index번째 수를 val로 바꾼다.
        //부모로 올라가면서 누적해서 바꾸면 된다.
        tree[index] = val % MOD;
        index /= 2;
        while (index > 0) {
            tree[index] = (tree[index*2]*tree[index*2+1])%MOD;
            index /= 2;
        }
    }

    private static void setTree(int i) { //초기 트리를 구성하는 함수
        while (i != 1) {
            tree[i / 2] =  (tree[i/2]*tree[i])%MOD;
            i--;
        }

    }
}
