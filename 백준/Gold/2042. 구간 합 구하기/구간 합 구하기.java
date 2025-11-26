import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); //수의 개수
        int M = Integer.parseInt(st.nextToken()); //변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 횟수

        int treeHeight = 0;
        int length = 1;

        while (length < N) {
            length <<= 1;
            treeHeight++;
        }
        //2^K * 2 = 2^(K+1) = 1 + 2 + 4 + 8 + ... + 2^treeHeight = 2^(treeHeight+1) -1 => 2^(treeHeight+1)로 커버.
        //루트노드 1번부터. 0번 안쓰니까 딱 2^(treeHeight+1)맞음
        //2^(h+1)
        int treeSize = 1 << (treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1; //2^k이 start_Index이다. 그것의 바로 직전 노드.
        tree = new long[treeSize];

        //데이터를 리프 노드에 입력받기
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) { //변경하기
                changeVal(leftNodeStartIndex + s, e);
            } else if (a == 2) { //구간 합 구하기
                //시작인덱스, 종료인덱스 맞추기. 즉, 트리배열에서의 값으로 맞추기
                s = s + leftNodeStartIndex; //s번쨰부터
                e = e + leftNodeStartIndex; //e번째까지
                sb.append(getSum(s, (int) e)).append('\n');
            } else {
                return;
            }
        }
        br.close();
        System.out.print(sb);

    }

    private static long getSum(int s, int e) { //구간 합을 구하는 함수
        long partSum = 0;
        while (s <= e) {
            if (s % 2 == 1) {
                partSum = partSum + tree[s];//start노드 선택
                s++;
            }
            if (e % 2 == 0) {
                partSum = partSum + tree[e];//end 노드 선택
                e--;
            }
            //부모로 올라가기
            s /= 2;
            e /= 2;
        }
        return partSum;
    }

    private static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index = index / 2; //부모로 올린다. 부모로 전파.
        }
    }

    private static void setTree(int i) { //초기 트리를 구성하는 함수
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
