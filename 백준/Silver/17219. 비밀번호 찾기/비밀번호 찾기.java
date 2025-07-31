import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String adr = st.nextToken();
            String pwd = st.nextToken();
            map.put(adr, pwd);
        }
        //n번연산

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            bw.write(map.get(st.nextToken()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
