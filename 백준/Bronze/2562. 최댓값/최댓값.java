import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[9];
        int count =0;
        int max =0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int j = 0; j < 9; j++) {
            if (arr[j] > max) {
                max = arr[j];
                count =j+1;
            }
        }
        System.out.println(max + "\n" + count);
    }
}

