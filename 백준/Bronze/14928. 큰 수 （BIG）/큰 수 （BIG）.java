import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String num = br.readLine();
        long remainder = 0;

        for (int i = 0; i < num.length(); i++) {
            remainder = (remainder * 10 + (num.charAt(i) - '0')) % 20000303;
        }

        bw.append(remainder + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
