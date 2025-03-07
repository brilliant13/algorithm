import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(new StringBuilder().append(st.nextToken()).reverse().toString());
        int B = Integer.parseInt(new StringBuilder().append(st.nextToken()).reverse().toString());
        System.out.println(Math.max(A, B));
    }
}
