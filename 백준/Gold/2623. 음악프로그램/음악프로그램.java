import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가수 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD 수

        // 그래프: graph[a] = a 다음에 와야 하는 노드들
        ArrayList<Integer>[] adj = new ArrayList[N + 1]; //1..based
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // indegree[x] = x로 들어오는 간선 수
        int[] indegree = new int[N + 1]; //1..based

        // 입력으로부터 그래프 구성
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 이번 줄에 나온 가수 수

            // 첫 번째 가수부터 읽기
            int prev = Integer.parseInt(st.nextToken()); //방향 그래프 입력

            // 이후 가수들을 읽으면서
            // prev -> cur 간선을 만든다.
            for (int j = 1; j < num; j++) {
                int cur = Integer.parseInt(st.nextToken());
                adj[prev].add(cur); // prev가 cur보다 먼저 와야 함
                indegree[cur]++; // cur의 진입차수 증가

                prev = cur; // 다음 연결을 위해 갱신
            }
        }

        // 진입차수가 0인 노드들을 큐에 넣는다.
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int processed = 0; // 위상정렬로 꺼내서 처리한 노드 개수

        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append('\n');
            processed++;

            // now 다음에 와야 하는 노드들 확인
            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }

        }

        if (processed != N) {  // 모든 노드를 다 처리하지 못했다면 // 사이클이 존재해서 순서를 정할 수 없는 경우
            System.out.print(0);
        } else {
            System.out.print(sb);
        }


    }
}