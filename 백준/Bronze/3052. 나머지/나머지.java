import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x;
        int arr[] = new int[10];
        int rest = 0;
        for (int i = 0; i < 10; i++) {
            x = Integer.parseInt(br.readLine());
            arr[i]=x%42;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        System.out.println(set.size());


    }
}