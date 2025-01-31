

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static long f(long a, long b) {
        return (a + b) * (a - b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(f(Long.parseLong(st.nextToken()) , Long.parseLong(st.nextToken())));

    }
}


