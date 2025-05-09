import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int i=0;
        while (st.hasMoreTokens()) {
            array[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(array);

//        int sum =0;
//        for (int k = 0; k < array.length; k++) {
//            for (int j = 0; j <= k; j++) {
//                sum += array[j];
//            }
//        }
        //시간복잡도를 개선해보자.  O(N²)에서 O(N log N)으로 개선
        int totalWaitTime =0;
        int cumulativeTime =0;

        for (int time : array) {
            cumulativeTime += time; // 현재 사람이 기다린 시간 + 인출 시간
            totalWaitTime += cumulativeTime; //총 대기시간에 누적
        }

        System.out.println(totalWaitTime);
    }
}
