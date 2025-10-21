import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String K = br.readLine();
//        int k = Integer.parseInt(K, 2);

        int count = 0;
        for (int i = 0; i < K.length(); i++) {
            if(K.charAt(i) == '1') count++;
        }
        System.out.println(count);

    }
}
