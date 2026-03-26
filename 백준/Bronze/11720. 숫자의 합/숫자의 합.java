import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;

        for(char ch : str.toCharArray()){
            int cur = ch - '0';
            sum += cur;
        }
        System.out.print(sum);
    }

}