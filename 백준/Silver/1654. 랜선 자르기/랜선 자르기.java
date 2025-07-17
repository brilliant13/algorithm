import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        //802 743 457 539 정수범위 초과할 수도 있음

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 457 539 743 802
        long low =1;
        //LongStream -> Long
        long high = Arrays.stream(arr).max().getAsLong();
        long result = 0;

        while(low<=high){

            long mid =(low+high)/2;
            long total = 0;
            //mid 길이로 몇 개의 랜선인지
            for (int i = 0; i < K; i++) {
                total += (arr[i]/mid);
            }

            if(total>=N) {
                result = mid; //현재 길이 저장
                low = mid+1; //더 긴 길이 시도
            }else if(total<N){
                high = mid-1; // 더 짧은 길이 시도
            }
        }
        System.out.println(result);

    }





}
