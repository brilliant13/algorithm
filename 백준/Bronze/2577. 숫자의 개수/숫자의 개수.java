import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int A,B,C;
        int arr[] = new int[10];

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        String ABC = String.valueOf(A * B * C);
        for (int i = 0; i < ABC.length(); i++) {
            arr[Integer.parseInt(String.valueOf(ABC.charAt(i)))]++;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }


}


