import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count =0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            boolean[] seen = new boolean[26]; //0~26. 0-based
            char previous = '\0';
            boolean isGroup = true;


            for (int j = 0; j < str.length(); j++) {
                char cur = str.charAt(j);
                if (cur != previous) {
                    //문자가 바뀌는 순간에만 체크
                    int idx = cur - 'a';
                    if (seen[idx]) {//예전에 나왔던 문자가 다시 등장 -> 그룹 단어 아님
                        isGroup=false;
                        break;
                    }
                    seen[idx] = true; //첫 등장 마킹
                    previous = cur; //현재 문자를 이전 문자로 업데이트
                }
                //같으면(연속 중이면) 그냥 진행
            }
            if(isGroup) count++;
        }
        System.out.print(count);
    }
}
