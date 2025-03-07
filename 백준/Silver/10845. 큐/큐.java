import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //push, pop, size, empty, front, back
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        int Last = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            switch (S) {
                case "push":
                    Last = Integer.parseInt(st.nextToken());
                    que.offer(Last);
                    break;
                case "pop":
                    if(que.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(que.poll()).append('\n');
                    break;
                case "size":
                    sb.append(que.size()).append('\n');
                    break;
                case "empty":
                    if(que.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(que.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(que.peek()).append('\n');
                    break;
                case "back":
                    if(que.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(Last).append('\n');
                    break;
            }
        }
        System.out.println(sb);

    }
}
