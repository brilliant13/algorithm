import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N]; // 2 4 -10 4 -9

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = Arrays.copyOf(a, a.length);
        Arrays.sort(temp); // -10 -9 2 4 4
        //-10 -9 2 4

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 0;
        for (int x : temp) {
            if(!rank.containsKey(x)) rank.put(x, r++);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : a) {
            sb.append(rank.get(x)).append(' ');
        }
        System.out.print(sb);

    }

}