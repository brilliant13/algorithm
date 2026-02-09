import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  // 사람 수
        int x = sc.nextInt();  // 권장 거리
        
        int maxDistance = (n - 1) * x;
        
        System.out.println(maxDistance);
        
        sc.close();
    }
}