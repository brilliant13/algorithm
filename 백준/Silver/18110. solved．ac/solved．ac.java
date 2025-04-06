import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        int check = (int) Math.round(n*0.15);
        int sum=0;
        for (int j = check + 1; j <= n - check; j++) {
            sum += array[j];
        }

        double avg= (double)sum / (n - (2 * check));
        System.out.println(Math.round(avg));
        
    }
}

