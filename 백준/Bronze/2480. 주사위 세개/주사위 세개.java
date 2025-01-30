import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        if (n == m && m == l)
            System.out.println(10000 + n * 1000);
        else if(n==m || n==l)
            System.out.println(1000+n*100);
        else if(m==l)
            System.out.println(1000+m*100);
        else
            System.out.println(Math.max(Math.max(n, m), l)*100);
    }
}
