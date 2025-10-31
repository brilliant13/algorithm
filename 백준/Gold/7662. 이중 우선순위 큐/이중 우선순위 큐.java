import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //이중 우선순위 큐는 우선순위 큐처럼 데이터를 삽입,삭제한다.
        //차이점은 명령에 따라 우선순위가 가장 높은 것 or 가장 낮은 것을 삭제한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            TreeMap<Integer, Integer> ms = new TreeMap<>();
            //k <= 1,000,000 정수
            //그냥 입력받고 정렬한 후에 순서대로 Double Ended Queue에 넣으면 될 것 같은데
            //동일한 값도 입력가능하고.
            int k = Integer.parseInt(br.readLine());
            // ‘D -1’는 Q 에서 최솟값을 삭제하는 연산
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int val = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    ms.merge(val, 1, Integer::sum);
                } else if (op == 'D') {
                    if(ms.isEmpty()) continue;

                    if (val == -1) {
                        //최솟값 삭제연산
                        int firstKey = ms.firstKey();
                        int current = ms.get(firstKey);
                        if(current>1) ms.put(firstKey, current - 1);
                        else ms.remove(firstKey);
                    } else {
                        //최댓값 삭제연산
                        int lastKey = ms.lastKey();
                        int current = ms.get(lastKey);
                        if(current>1) ms.put(lastKey, current - 1);
                        else ms.remove(lastKey);
                    }
                }
            }

            if (ms.isEmpty()) sb.append("EMPTY" + "\n");
            else sb.append(ms.lastKey()).append(" ").append(ms.firstKey()).append('\n');

//            if (T != 1) sb.append(" ");
        }
        System.out.print(sb);

    }
}

