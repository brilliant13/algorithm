import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
 
    static int code1Cnt, code2Cnt;
    static int[] dp;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        dp = new int[n];
        
        br.close();
        
        code1Cnt = 0;
        code2Cnt = 0;
        
        fib(n);
        fibonacci(n);
        
        System.out.println(code1Cnt +" "+code2Cnt);
    }
    
    static int fib(int n){
        if(n==1 || n==2){
            code1Cnt++;
            return 1;
        }
        else return (fib(n-1)+fib(n-2));
    }
    
    static int fibonacci(int n){
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<n; i++){
            code2Cnt++;
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n-1];
    }
}