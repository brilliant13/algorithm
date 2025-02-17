import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] q = new int[2 * N];
        for (int i = 1; i <= N; i++) {
            q[i]=i;
        }
        int prev_index = 1;
        int last_index =N;

        while (N-- > 1) {
            prev_index++;
            q[last_index +1]=q[prev_index];
            last_index++;
            prev_index++;
        }
        System.out.println(q[prev_index]);


    }


}