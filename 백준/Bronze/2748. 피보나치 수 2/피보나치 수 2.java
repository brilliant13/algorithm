import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        Arrays.fill(arr, -1);
        System.out.println(Fib(N));
    }

    static long Fib(int N) {
        if(N==0) return arr[0]=0;
        if(N==1) return arr[1]=1;
        if (arr[N] == -1) {
            arr[N] = Fib(N - 2) + Fib(N - 1);
        }
        return arr[N];
    }



//    static int fibo(int N) {
//        if(N==0) return arr[0]=0;
//        else if(N==1) return arr[1]=1;
//        else return arr[N]=fibo(N - 2) + fibo(N - 1);
//    }

}
