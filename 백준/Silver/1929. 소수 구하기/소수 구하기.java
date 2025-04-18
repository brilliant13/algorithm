import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        //M이상 N이하의 소수를 모두 출력하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        //두 값 사이의 소수 판정
        prime = new boolean[N + 1]; //0~N
        get_prime();

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);

    }

    public static void get_prime() {
        //ture = 소수 x , false = 소수
        prime[0]=prime[1]=true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

}

