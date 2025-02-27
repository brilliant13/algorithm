import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int sequence;

    public static void main(String[] args) throws IOException {
        //N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)
        //정점 번호는 1~N번이고, 모든 간선의 가중치는 1이다.
        //정점 R에서 시작하여 깊이 우석 탐색Depth First Search)로 노드를 방문할 경우 노드의 방문 순서를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //정점의 수
        int M = Integer.parseInt(st.nextToken()); //간선의 수
        int R = Integer.parseInt(st.nextToken()); //시작정점

        check = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        sequence = 1; //시작 정점 1
        dfs(R);
        // 각 인덱스별로 방문 순서가 기록된 배열을 순회하며, 값을 StringBuilder에 저장
        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int vertex) {
        //현재 방문하고 있는 정점에 순서 저장
        check[vertex] = sequence;
        //현재 위치한 정점이 갈 수 있는 정점 리스트를 순회
        for (int i = 0; i < graph.get(vertex).size(); i++) {
            int newVertex = graph.get(vertex).get(i);
            //다음 갈 정점을 방문했었는지 체크 (0일 경우 방문x)
            if (check[newVertex] == 0) {
                sequence++;
                dfs(newVertex);
            }
        }

    }

}
