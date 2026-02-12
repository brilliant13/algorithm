import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //위상정렬은 유향그래프에서 변의 방향을 거스르지 않고 꼭지점들을 나열하는 것이다.
        //인접 리스트: graph[A] = A보다 뒤에 서야 하는 학생들
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) { //1-based
            graph.add(new ArrayList<>());
        }

        //진입 차수(Indegree): 나보다 앞에 서야 하는 학생이 몇 명인지
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B); // A -> B (A가 B보다 앞이다. 이 순서를 방향 그래프로 나타내는 것이다.)
            inDegree[B]++; //방향 생겼으니, 진입 차수 올려주고.
        }

        //진입 차수가 0인 학생 = 앞에 아무도 없으니 먼저 설 수 있다. = 선수과목 제한이 없거나 조건 다 충족했으니 수강가능!
        Queue<Integer> queue = new LinkedList<>();
        //LinkedList대신 ArrayDeque으로도 구현가능. 내부 배열 기반이라 캐시 지역성도 좋고 메모리도 적게씀.
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(' ');

            //cur 뒤에 서야 하는 학생들의 진입 차수 감소
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) { //앞에 설 사람 다 처리됨(모든 선수 조건 충족된 상태) -> 큐에 추가
                    queue.offer(next);
                }
            }
        }
        //큐가 빌 때까지 Step1, Step2를 반복하면 답이다.
        System.out.print(sb);



    }
}