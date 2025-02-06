import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i]=Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[N - 1]);

    }
}