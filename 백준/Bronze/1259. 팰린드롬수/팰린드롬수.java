import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            bw.write(check(input)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static String check(String s) {
        int length = s.length();
        int half = length/2;

        if (length % 2 == 0) {
            for (int i = 0; i < half; i++) {
                if (s.charAt(i) != s.charAt(length - 1 - i)) return "no";
            }
        } else {
            for (int j = 0; j < half + 1; j++) {
                if (s.charAt(j) != s.charAt(length - 1 - j)) return "no";
            }
        }
        return "yes";
    }
}