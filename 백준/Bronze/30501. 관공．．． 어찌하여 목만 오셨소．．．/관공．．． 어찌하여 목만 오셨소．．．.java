import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str ="";
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if (str.contains("S")) {
                System.out.println(str);
                return;
            }
        }
    }

}