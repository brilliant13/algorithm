import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total =0;
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            total +=a*a;
        }
        System.out.println(total % 10);
    }
}


