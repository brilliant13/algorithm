import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int [][] info;
    static int [] dungchi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        info = new int[N][2];
        dungchi = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
                    rank++;
                }
            }
            dungchi[i]=rank;
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }

}
