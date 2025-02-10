import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[][] arr = new String[T][2];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]=st.nextToken();
            arr[i][1]=st.nextToken();
        }

        //나이순 정렬
        Arrays.sort(arr, new Comparator<String[]>(){
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }
        });

        for (int i = 0; i < T; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);

    }
}