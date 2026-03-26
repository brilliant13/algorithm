import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int[] arr = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur>max) max = cur;
            sum+=cur;
        }
        System.out.print(sum*100.0/max/N);
//        System.out.print((double)sum*100/max/3);
    }

}