import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static long[] MinTree;
    static long[] MaxTree;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        //N개의 정수들이 있다.
        //a번째 정수부터 b번째 정수까지 중에서 제일 작은 정수 or 제일 큰 정수 => 구간 최대,최소 -> 세그먼트 트리
        // 1이상 1,000,000,000이하 int가능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //트리 사이즈 구하기
        int length = 1;
        int treeHeight = 0;
        while (length < N) {
            length <<= 1;
            treeHeight++;
        }

        int treeSize = 1 << (treeHeight + 1);
        MinTree = new long[treeSize]; //0..31
        MaxTree = new long[treeSize]; //0..31

        //비교를 위한 초기화
        Arrays.fill(MinTree, Long.MAX_VALUE);
        Arrays.fill(MaxTree, Long.MIN_VALUE);


        int leftNodeStartIndex = (1 << treeHeight) - 1;
        for (int i = 1; i <= N; i++) {
            long val = Long.parseLong(br.readLine());
            MinTree[leftNodeStartIndex + i] = val;
            MaxTree[leftNodeStartIndex + i] = val;
        }

        setMinTree(treeSize - 1);
        setMaxTree(treeSize - 1);


        //쿼리 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //질의를 트리의 리프 인덱스로 옮겨주는 작업 해야한다.
            sb.append(getMin(leftNodeStartIndex + a, leftNodeStartIndex + b)).append(" ").append(getMax(leftNodeStartIndex + a, leftNodeStartIndex + b)).append('\n');
        }
        System.out.print(sb);

    }

    private static long getMin(int s, int e) { //구간 최대, 최소 구하는 함수
        long min = Long.MAX_VALUE;

        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, MinTree[s]);
                s++;
            }
            if (e % 2 == 0) {
                min = Math.min(min, MinTree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return min;
    }

    private static long getMax(int s, int e) { //구간 최대, 최소 구하는 함수
        long max = Long.MIN_VALUE;

        while (s <= e) {
            if (s % 2 == 1) {
                max = Math.max(max, MaxTree[s]);
                s++;
            }
            if (e % 2 == 0) {
                max = Math.max(max, MaxTree[e]);
                e--;
            }

            //부모 올로가자.
            s /= 2;
            e /= 2;
        }
        return max;
    }

    private static void setMinTree(int i) { //초기 트리를 구성하는 함수
        while (i != 1) {
            MinTree[i / 2] = Math.min(MinTree[i / 2], MinTree[i]);
            i--;
        }
    }

    private static void setMaxTree(int i) { //초기 트리를 구성하는 함수
        while (i != 1) {
            MaxTree[i / 2] = Math.max(MaxTree[i / 2], MaxTree[i]);
            i--;
        }
    }
}
