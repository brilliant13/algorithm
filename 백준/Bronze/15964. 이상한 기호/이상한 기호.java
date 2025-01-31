import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int f(int a, int b) {
        return (a + b) * (a - b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(f(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));

    }
}

