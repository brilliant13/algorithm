import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
//    static boolean[] impossibleCandidate;
    static boolean[] inCycle;
//    static boolean[] monoCycle;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 학생의 수 N <= 100,000

            //테스트 케이스별로 정적변수 재할당. 새로 만들어서 레퍼런스변수에 넣어줌. 새로운 주소값(레퍼런스값) 가져서 새로운 공간을 가리킴.
            visited = new boolean[N + 1]; // 1..based
//            impossibleCandidate = new boolean[N + 1]; // 1..based
//            monoCycle = new boolean[N + 1]; // 1..based
            inCycle = new boolean[N + 1];
            arr = new int[N + 1]; // 1..based

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) { // 선택된 학생들의 번호
                int cur = Integer.parseInt(st.nextToken());
                arr[i] = cur;
//                if(i==cur) monoCycle[i]=true; //자기자신 순환이면 표시
            }

            // 1~N 까지 깊이 우선 탐색(DFS)
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
//                visited[i] = true;
                dfs(i);
            }

            //어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하라
            //impossibleCandidate에서 True개수
            int count = 0;
            for (int i = 1; i <= N; i++) {
//                if(impossibleCandidate[i]) count++;
                if(!inCycle[i]) count++;
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int start) {
        ArrayList<Integer> path = new ArrayList<>();
        int cur = start;

        while (!visited[cur]) {
            visited[cur] = true;
            path.add(cur);
            cur = arr[cur];
        }

        int cycleStart = path.indexOf(cur);

        if (cycleStart != -1) {
            for (int i = cycleStart; i < path.size(); i++) {
                inCycle[path.get(i)] = true;
            }
        }
        //cycleStart 이전 노드들은 inCycle = false( 기본값 ) -> 팀 불가
    }
}