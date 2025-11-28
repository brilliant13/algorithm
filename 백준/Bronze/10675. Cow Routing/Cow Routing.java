import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            // cost, 도시 개수
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            boolean seenA = false;
            boolean canUse = false;

            for (int j = 0; j < cnt; j++) {
                int city = Integer.parseInt(st.nextToken());

                if (city == A) {
                    seenA = true;
                }
                if (seenA && city == B) {
                    canUse = true;
                }
            }

            if (canUse) {
                answer = Math.min(answer, cost);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
