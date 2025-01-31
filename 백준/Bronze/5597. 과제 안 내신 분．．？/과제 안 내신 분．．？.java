import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31]; //0~30
        int num = 0;
        for (int i = 1; i <= 28; i++) {
            num = Integer.parseInt(br.readLine());
            arr[num] = 1;
        }
        //탐색
        for (int j = 1; j <= 30; j++) {
            if (arr[j] == 0) {
                System.out.println(j);
            }
        }
    }
}

