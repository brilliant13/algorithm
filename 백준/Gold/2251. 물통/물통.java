import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A,B,C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Set<Integer> result = bfs();
        //Set<Integer> -> Stream<Integer>
        result.stream().sorted()
                .forEach(x -> System.out.print(x + " "));


    }

    private static Set<Integer> bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[A+1][B+1][C+1];
        Set<Integer> result = new HashSet<>();

        queue.offer(new int[]{0, 0, C});
        visited[0][0][C]=true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int a = current[0];
            int b = current[1];
            int c = current[2];

            if (a == 0) {
                result.add(c);
            }

            //순열. 3가지 물통 서로 주고받는 경우의수. 3_P_2 = 3x2 = 6가지
            //A->B
            int pourAB = Math.min(a,B-b); //현재 부을 수 있는 양 비교
            if (pourAB > 0) {
                tryAddState(queue, visited, a - pourAB, b + pourAB, c);
            }
            //A->C
            int pourAC = Math.min(a, C - c); //현재 부을 수 있는 양
            if (pourAC > 0) {
                tryAddState(queue, visited, a - pourAC, b, c + pourAC);
            }
            //B->A
            int pourBA = Math.min(b, A - a);
            if (pourBA > 0) {
                tryAddState(queue,visited,a+pourBA,b-pourBA,c);
            }
            //B->C
            int pourBC = Math.min(b, C - c);
            if (pourBC > 0) {
                tryAddState(queue,visited,a,b-pourBC,c+pourBC);
            }
            //C->A
            int pourCA = Math.min(c, A - a);
            if (pourCA > 0) {
                tryAddState(queue,visited,a+pourCA,b,c-pourCA);
            }
            //C->B
            int pourCB = Math.min(c, B - b);
            if (pourCB > 0) {
                tryAddState(queue,visited,a,b+pourCB,c-pourCB);
            }
        }

        return result;
    }

    private static void tryAddState(Queue<int[]> queue, boolean[][][] visited, int a, int b, int c) {
        if (!visited[a][b][c]) {
            visited[a][b][c] = true;
            queue.offer(new int[]{a, b, c});
        }
    }

}
