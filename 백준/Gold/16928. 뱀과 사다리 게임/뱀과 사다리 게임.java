import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //게임판의 상태가 주어짐 -> 100번 칸에 도착하기 위한 최소 주사위 횟수
        int[] board = new int[101]; //1-based. 1~100
//        Arrays.fill(board, -1);
        boolean[]visited = new boolean[101];

        int a = N + M;

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            board[from] = to;
        }

        //BFS 너비우선탐색. 같은 Level에 속하는 것들이 주사위 던진 횟수가 동일
        //최초 100에 도달하는 level이 정답. 그 회차의 모든 것들이 다 같은 횟수임.
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1]= true;

//        System.out.println("offer(nxt) = " + 1);
//        System.out.println("Level: = " + 0);
//        System.out.println("======================");
        int count = 0;
        //snakes and ladders 없으면 주사위6만 큐에 넣어가면 된다. 최대한 많이 이동해야되니까.
        //다음 level의 큐에 들어가는 건 snake or ladder or dice 6
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
//            System.out.println("Level: = " + count);

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int nxt = cur + j;

                    //도착 check
                    if (nxt == 100) {
//                        System.out.println("찾았다 100");
//                        System.out.println("nxt = " + nxt);
                        System.out.println(count);
                        return;
                    }
                    if (nxt > 100) continue;

                    //사다리x, 뱀x
                    if (!visited[nxt] && board[nxt] == 0) {
                        visited[nxt] = true;
                        q.offer(nxt);
//                        System.out.println("offer(nxt) = " + nxt);
                        continue;
                    }
                    //snake or ladder
                    if (!visited[nxt] && board[nxt] != 0) {
                        nxt = board[nxt]; //갱신
                        //이미 방문한 곳은 다시 방문하지 않는다. 심지어 같은 층에서 주사위로 던져서 이동한 곳이랑 사다리이동이랑 겹쳐도 횟수가 같기에 이득이 없다.
                        visited[nxt] = true;
                        q.offer(nxt);
                    }

//                    System.out.println("offer(nxt) = " + nxt);
                }
//                System.out.println("======================");
            }

        }


    }

}

