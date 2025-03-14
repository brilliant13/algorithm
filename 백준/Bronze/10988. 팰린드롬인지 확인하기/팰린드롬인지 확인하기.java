import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //10988 팰린드롬인지 확인
        //앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말함.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //길이받고. 처음과 끝 비교. 다르면 바로 0리턴. lenths/2까지 반복
        String str = br.readLine();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);

    }

}
