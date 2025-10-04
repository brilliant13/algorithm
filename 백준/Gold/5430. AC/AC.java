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

        while (T-- > 0) {
            //RDD
            //4
            //[1,2,3,4]
            String p = br.readLine().trim();
            int n = Integer.parseInt(br.readLine().trim());
            String arr = br.readLine().trim();

            Deque<Integer> dq = parseArrayFast(arr, n);
            boolean rev = false;
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                if (c == 'R') {
                    rev = !rev;
                } else { //'D'
                    Integer removed = rev ? dq.pollLast() : dq.pollFirst();
                    if (removed == null) {//빈 덱에서 삭제 시도
                        error = true;
                        break;
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                printDeque(dq, rev);
            }
        }
        System.out.print(sb);
    }

    //정규식 split 없이 직접 숫자 파싱: 공백/두자리/세자리 모두 안전
    private static Deque<Integer> parseArrayFast(String arr, int n) {
        Deque<Integer> dq = new ArrayDeque<>(n);
        if(n==0) return dq; //"[]"

        int len = arr.length();
        int num = 0;
        boolean inNumber = false;

        // arr: "[1,2,33]" 형태. 숫자만 모아 int로 반환
        for (int i = 0; i < len - 1; i++) {//양 끝 대괄호 제외
            char ch = arr.charAt(i);
            if (ch >= '0' && ch <= '9') {
                inNumber = true;
                num = num * 10 + (ch - '0');
            } else{
                if(inNumber){//숫자 종료 시점(콤마/공백/끝)
                    dq.offer(num);
                    num = 0;
                    inNumber = false;
                }
            }
        }
        if(inNumber) dq.offer(num); //마지막 숫자처리
        return dq;
    }

    private static void printDeque(Deque<Integer> dq, boolean rev) {
        sb.append('[');
        if (!dq.isEmpty()) {
            if (!rev) {
                sb.append(dq.pollFirst());
                while (!dq.isEmpty()) sb.append(',').append(dq.pollFirst());
            } else {
                sb.append(dq.pollLast());
                while(!dq.isEmpty()) sb.append(',').append(dq.pollLast());
            }
        }
        sb.append("]\n");
    }

}
