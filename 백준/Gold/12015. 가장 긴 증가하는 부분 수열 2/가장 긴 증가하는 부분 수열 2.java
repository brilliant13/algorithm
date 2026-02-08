import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tails = new int[N];
        int len = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            int pos = lowerBound(tails,len, x);
            tails[pos] =x;
            if(pos==len) len++;
        }
        System.out.println(len);

    }
    // lower_bound: tails(0..len)에서 "처음으로 >= x"가 되는 위치. 하한.
    static int lowerBound(int[] tails, int len, int x ) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo+hi) >>1;
            if(tails[mid] >= x) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
}