import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int countA = 0, countB = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'a') countA++;
                else countB++; // 'b'
            }

            sb.append(Math.min(countA, countB)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
