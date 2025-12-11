import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append('\n');
        }
        System.out.print(sb);
    }

    static String bfs(int start, int target) {
        //A,B 모두 0이상 10,000미만이다. 즉 만가지의 상태를 저장할 변수를 선언하고 활용한다.
        boolean[] visited = new boolean[10000];
        int[] prev = new int[10000]; //이전 상태 저장용
        char[] how = new char[10000]; //어떤 연산으로 왔는지

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        prev[start] = -1; //시작점 표시

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) break;

            //D,S,L,R 순서대로
            int[] nexts = {
                    D(cur),
                    S(cur),
                    L(cur),
                    R(cur)
            };
            //현재 Level에서 다음 Level로 4가지 갈래로 뻣어나감
            char[] ops = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int nxt = nexts[i];
                if (!visited[nxt]) { //한번 방문한 건 재방문 안 함. 재방문 한다는 건 같은 level 또는 다음 level이라 최단거리에 영향 안 준다. 즉, 볼필요없다.
                    //처음 나오는 놈이 최단거리라고 생각해도 됨.

                    visited[nxt] = true;
                    prev[nxt] = cur; //이전 상태를 저장한다.
                    how[nxt] = ops[i]; //이 연산 진행할 때 어떤 연산으로 진행되었는지 기록.
                    q.add(nxt); //다음 Level로 가기 위해 큐에 offer()
                }
            }
        }

        //target에서부터 역추적
        StringBuilder sb = new StringBuilder();
        int cur = target;
        while (prev[cur] != -1) {
            sb.append(how[cur]);
            cur = prev[cur]; //이전 노드로 올라가면서 역추적
        }

        return sb.reverse().toString();

    }

    static int D(int a) {
        return (2 * a) % 10000;
    }

    static int S(int a) {
        return a == 0 ? 9999 : a - 1;
    }

    static int L(int a) {
        return (a % 1000) * 10 + a / 1000;
    }

    static int R(int a) {
        return (a / 10) + (a % 10) * 1000;
    }
}
