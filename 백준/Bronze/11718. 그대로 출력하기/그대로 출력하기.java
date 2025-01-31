import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while ((str = br.readLine()) != null && str.charAt(0) != ' '&&str.charAt(str.length()-1)!=' ' && str.length() <= 100) {
            bw.write(str + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}

