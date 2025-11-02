import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 1; i <= n; i++) {
            sum1 = sum1 + i;
        }
        System.out.println(sum1);
        for (int j = 1; j <= n; j++) {
            sum2 = sum2 + j;
        }
        System.out.println(sum2 * sum2);
        for (int k = 1; k <= n; k++) {
            sum3 = (sum3 + (k * k * k));
        }
        System.out.println(sum3);
    }
}