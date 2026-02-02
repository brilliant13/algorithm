import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        //fib(n)은 {F(n), F(n+1)}를 MOD로 나눈 값을 반환한다.
        long[] ans = fib(n);

        //n번째 피보나치 출력
        System.out.println(ans[0]);
    }

    /**
     * fib(n) = {F(n) , F(n+1)} (mod MOD)를 반환하는 Fast Doublic 재귀
     * <p>
     * 핵심 아이디어:
     * n을 절반으로 줄인 k=n/2에 대해서 {F(k), F(K+1)}만 알면
     * 공식으로 {F(2k), F(2k+1)}를 O(1)로 만들 수 있다.
     * <p>
     * 재귀 깊이: log(n) (n <= 1e18이면 약 60) -> 안전
     */
    static long[] fib(long n) {
        //base case:
        //F(0)=0, F(1)=1 이므로 {F(0), F(1)} = {0,1}
        if (n == 0) return new long[]{0, 1};

        //1) 먼저 절반 문제를 푼다: k=n/2
        long[] half = fib(n / 2);
        long a = half[0]; // a = F(k) mod MOD
        long b = half[1]; // b = F(k+1) mod MOD

        //2) 이제 공식으로 F(2k), F(2k+1)을 만든다.
        //
        // Fast Doubling 공식:
        //   F(2k)   = F(k) * (2*F(k+1) - F(k))
        //   F(2k+1) = F(k)^2 + F(k+1)^2
        //
        // 여기서 모든 연산은 MOD로 나눈 나머지로 진행한다.

        // (2*b - a) 는 음수가 될 수 있으므로 "모듈러 뺄셈"으로 안전하게 처리해야 한다.
        // subMod(x, y) = (x - y) mod MOD 를 0..MOD-1 범위로 만들어 준다.
        long twoB = mulMod(2, b);                 // (2*b) % MOD
        long twoBMinusA = subMod(twoB, a);        // (2*b - a) mod MOD  (음수 방지)

        long c = mulMod(a, twoBMinusA);           // c = F(2k) mod MOD
        long d = addMod(mulMod(a, a), mulMod(b, b)); // d = F(2k+1) mod MOD

        //3) n이 짝수면 n=2k, 홀수면 n=2k+1
        if (n % 2 == 0) {
            //{F(2k),F(2k+1)}
            return new long[]{c, d};
        } else {
            // n = 2k+1 인경우:
            //F(n) = F(2k+1) = d
            //F(n+1) = F(2k+2) = F(2k) + F(2k+1) => 2k+2번째 피보나치수 => c + d
            return new long[]{d, addMod(c, d)};
        }
    }

    /**
     * (x + y) mod MOD
     */
    static long addMod(long x, long y) {
        long res = x + y;
        if (res >= MOD) res -= MOD; // 한 번만 넘을 수 있으니 빠르게 처리
        return res;
    }

    /**
     * (x - y) mod MOD 를 0..MOD-1 범위로 반환
     * <p>
     * 자바에서 (-1 % MOD) = -1 이라서,
     * 음수 결과가 나오면 MOD를 더해 양수로 보정해준다.
     * MOD=7일 떄 -3 과 4 는 같다. (모듈러에서 -3과 4는 같다.)
     */
    static long subMod(long x, long y) {
        long res = x - y;
        if (res < 0) res += MOD;
        return res;
    }

    /**
     * (x * y) mod MOD
     * <p>
     * 여기서는 x,y가 항상 0..MOD-1 범위고
     * MOD ≈ 1e9 이므로 곱은 ≈ 1e18 수준 -> long 범위(≈9e18) 안이라 안전.
     */
    static long mulMod(long x, long y) {
        return (x * y) % MOD;
    }
}
