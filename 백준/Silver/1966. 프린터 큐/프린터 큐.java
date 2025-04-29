import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>(); //[중요도, 원래 위치] 저장 큐

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{priority, i});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll(); //현재 문서 [중요도, 원래 위치]
                boolean hasHigherPriority = false;

                for (int[] doc : queue) {
                    if (doc[0] > current[0]) {
                        hasHigherPriority = true;
                        break;
                    }
                }
                if (hasHigherPriority) {
                    queue.offer(current);
                } else {
                    //현재 문서가 가장 높은 중요도라면 인쇄
                    count++;
                    if (current[1] == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
        
    }
}

