import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] chars = new char[L];

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            chars[i]=str.charAt(i);
        }
        System.out.println(hash(chars));

    }

    static long hash(char[] chars) {
        long r = 31;
        long M = 1234567891;
        long power = 1;
        long result =0;
        for (int i = 0; i < chars.length; i++) {
//            result += ((chars[i]-'a'+1)%M)*(power%M);
//            power*=r;
            result = (result + (chars[i]-'a'+1) * power) % M;
            power = (power * r) % M;
        }
        return result;
    }

}