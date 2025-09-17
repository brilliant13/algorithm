import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //a=97,z=122 A=65,Z=90 알파벳26개
        int count =0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine(); //happt
            boolean[] alpha = new boolean[26]; //0~26. 0-based
            boolean flag = true;

            char cur = str.charAt(0);
            alpha[cur-'a'] = true;

            for (int j = 1; j < str.length(); j++) {
                //문자 'h' -> 'h'-'a' = 해당 인덱스
                char next = str.charAt(j);
                int idx = next - 'a';

                //이전 숫자랑 같다면
                if (cur == next) {
                    continue;
                }
                //이전 숫자랑 다르다면
                else {
                    if (alpha[idx]) {
                        flag = false;
                        break;
                    } else {
                        alpha[idx]=true;
                    }
                }
                cur = next;
            }
            if(flag) count++;
        }
        System.out.print(count);
    }
}
