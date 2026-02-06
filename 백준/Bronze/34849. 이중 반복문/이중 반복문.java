import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        
        if (n * n <= 100000000) {  // 10^8 = 100,000,000
            System.out.println("Accepted");
        } else {
            System.out.println("Time limit exceeded");
        }
    }
}