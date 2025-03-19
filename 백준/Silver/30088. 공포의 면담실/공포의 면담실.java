import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] sum = new int[N+1];
        int end=0;
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            for (int j = 0; j < people; j++) {
                int value =Integer.parseInt(st.nextToken());
                list.get(i).add(value);
                sum[i+1] += value;
            }
        }
        Arrays.sort(sum);
        int count = N;
        for (int i = 1; i < N + 1; i++) {
            for (int j = count; j > 0; j--) {
                end += sum[i];
            }
            count --;
        }
        System.out.println(end);

    }

}