import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (name.indexOf('S') >= 0) { // 또는 name.contains("S")
                System.out.println(name);
                return; // 유일하므로 바로 종료
            }
        }
    }
}
