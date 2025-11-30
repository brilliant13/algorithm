import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int S = Integer.parseInt(br.readLine());   // 고속철도
        int F = Integer.parseInt(br.readLine());   // 항공편
 
        // 소요 시간 적게 걸리는 교통 수단을 이용
        if(S <= F)
        {
            System.out.println("high speed rail");
        }
        else System.out.println("flight");
 
    }
}
