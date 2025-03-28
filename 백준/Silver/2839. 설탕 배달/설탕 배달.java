import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //사탕가게에 설탕을 정확하게 N킬로그램 배달해야 한다. 3kg or 5kg 봉지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int five = N / 5;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = five; i >= 0; i--) {
            int x = N - (5 * i);
//            if (x % 3 != 0) {
//                list.add(-1);
//            }
            if(x%3 ==0) {
                list.add(i + (x / 3));
            }
        }

        int min = list.stream()
                .filter(x -> x != -1)
                .min(Integer::compareTo)
                .orElse(-1);
        System.out.println(min);
    }
}

