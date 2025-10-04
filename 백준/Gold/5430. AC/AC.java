import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //R은 배열을 뒤집는다. D는 배열의 첫 번째 수를 버린다.
        //배열이 비어있는데 D를하면 error
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            ac(p, n, arr);
        }
        System.out.println(sb);
    }

    private static void ac(String p, int n, String arr) {
        //p = RDD, n = 4, arr = [1,2,3,4]  arr = [12,24,33344,12323]
        boolean reverse = false;
        Deque<Integer> dq = new ArrayDeque<>();

        String nums = "";

        if (n == 0) {
            nums = "[]";
        } else {
            nums = arr.substring(1, arr.length() - 1);
        }
        String[] numList = nums.split(",");

//        for (String s : numList) {
//            System.out.println("numList = "+s);
//        }
//        System.out.println();


        if (n != 0) {
            for (String num : numList) {
                dq.offer(Integer.parseInt(num));
            }
        }


        for (int j = 0; j < p.length(); j++) {
            char ch = p.charAt(j);
            if (ch == 'R') {
                reverse = !reverse;
            }
            if (ch == 'D') {
//                if (dq.isEmpty()) {
//                    sb.append("error").append('\n');
//                    return;
//                }
                Integer x = reverse ? dq.pollLast() : dq.pollFirst();
                if (x == null) {
                    sb.append("error").append('\n');
                    return;
                }
                
//                if (reverse) {
//                    dq.removeLast(); //없으면 예외
//                } else {
//                    dq.removeFirst();
//                }
            }
        }
        int size = dq.size();
        if (size == 0) {
            sb.append("[]").append('\n');
            return;
        }
        if (reverse) {
            sb.append('[');
            while (!dq.isEmpty()) {
                sb.append(dq.pollLast()).append(dq.isEmpty() ? "" : ',');
            }
            sb.append(']').append('\n');
        } else {
            sb.append('[');
            while (!dq.isEmpty()) {
                sb.append(dq.pollFirst()).append(dq.isEmpty() ? "" : ',');
            }
            sb.append(']').append('\n');
        }

    }
}
