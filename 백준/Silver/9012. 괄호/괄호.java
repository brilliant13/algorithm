import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    char [] chars;
    public static void main(String[] args) throws IOException {

        //() VPS
        //( VPS ) = VPS
        // VPS+VPS = VPS
        //  (  ())(   )  ((()))
        // 왼쪽 bracket과 오른쪽 bracket의 개수가 같아야 함.
        // 처음은 무조건 ( 이어야하고 그것이 아니면 No
        // (count와 )count가 같아야 함.  )count가 (count보다 크면 No

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String vps = is_VPS(br.readLine());
            sb.append(vps).append('\n');
        }
        System.out.println(sb);
    }

    public static String is_VPS (String chars) {
        //String을 char배열로 넣는다.
        int left_count =1;
        int right_count=0;
        if (chars.charAt(0) == ')') {
            return "NO";
        } else {
            for (int i = 1; i < chars.length(); i++) {
                if (chars.charAt(i) == '(') {
                    left_count++;
                } else {
                    right_count++;
                }
                if(right_count > left_count){
                    return "NO";
                }
            }
            return (left_count == right_count) ? "YES" : "NO";
        }
    }
}