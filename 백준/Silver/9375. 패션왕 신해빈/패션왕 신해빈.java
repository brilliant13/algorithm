import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> countMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split(" ");
                countMap.put(tokens[1], countMap.getOrDefault(tokens[1], 0) + 1);
//                System.out.println("tokens[1] = " + tokens[1]);
//                System.out.println("countMap.get(tokens[1]) = " + countMap.get(tokens[1]));
            }

            int count = 1;
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                count *= (entry.getValue()+1);
//                System.out.println("count = " + count);
            }
            count--; //와도되고 안와도되고 경우의수 곱셈법칙. (0,1,2), (0,1)중  (0,0), 즉 알몸일 때는 빼야되니까 1뺀다.
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}