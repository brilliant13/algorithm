import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //대->소
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else{
                //소->대
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb);
        
    }
}

