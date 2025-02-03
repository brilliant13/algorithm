import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Test case 수 입력
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        String[] strAry = new String[N];
        //단어 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            strAry[i] = st.nextToken();
        }
        //단어 정렬, 사용자화
        Arrays.sort(strAry, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                //단어 길이 같은 경우
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2); //사전순 정렬
                }
                //그 외
                else {
                    return s1.length() - s2.length();
                }
            }
        });
//        람다
//        Arrays.sort(strAry, (s1, s2) -> {
//            //단어 길이 같은 경우
//            if (s1.length() == s2.length()) {
//                return s1.compareTo(s2); //사전순 정렬
//            }
//            //그 외
//            else {
//                return s1.length() - s2.length();
//            }
//        });

        StringBuilder sb = new StringBuilder();
        System.out.println(strAry[0]);

        for (int i = 1; i < N; i++) {
            //중복x
            if(strAry[i].equals(strAry[i-1])){
                continue;
            }
            sb.append(strAry[i]).append('\n');
        }
        System.out.println(sb);
    }
}