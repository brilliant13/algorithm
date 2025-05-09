import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int i=0;
        while (st.hasMoreTokens()) {
            array[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(array);

        // 1 2 3 3 4
        // 1 + (1+2) + (1+2+3) + (1+2+3+3) + (1+2+3+3+4)
        int sum =0;
        for (int k = 0; k < array.length; k++) {
            for (int j = 0; j <= k; j++) {
                sum += array[j];
            }
        }
        System.out.println(sum);
    }
}
