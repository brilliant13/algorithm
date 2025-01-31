

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int f(int [] arr) {
        int sum =0;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i]*arr[i];
        }
        return sum%10;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = st.countTokens();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(f(arr));

    }
}


