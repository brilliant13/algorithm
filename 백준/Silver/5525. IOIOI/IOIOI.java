import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //N = 1 => IOI
        //S의 길이 = 13
        //문자열 S = OOIOIOIOIIOII

        //I로 시작하는 인덱스 -> 그 인덱스에서 문자열 길이만큼 잘라서 Pn과 같은지 비교 equals
        //Pn = 2백만
        //S = 백만
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("IO");
        }
        sb.append("I");
        String str = sb.toString();
        int length = str.length();
        int count = 0;

        //startsWith(string, offset)
        for (int i = 0; i + length <= S.length(); i++) {
            if (S.startsWith(str, i)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
