import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();

        int missingIdx = str.indexOf('*');

        //index 찾아서 0~9까지 Brute_Force
        for (int i = 0; i <= 9; i++) {
            chars[missingIdx] = (char) ('0' + i);
            int sum =0;

            for (int j = 0; j < 13; j++) {
                int digit = chars[j]-'0';
                int weight = (j % 2 == 0) ? 1 : 3;
                sum += digit*weight;
            }

            if (sum % 10 == 0) {
                System.out.print(i);
                break;
            }
        }


    }

}
