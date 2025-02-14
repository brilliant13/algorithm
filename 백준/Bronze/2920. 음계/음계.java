import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine().replace(" ", ""));
        System.out.println(v == 12345678 ? "ascending" : v == 87654321 ? "descending" : "mixed");
        br.close();
    }
}




