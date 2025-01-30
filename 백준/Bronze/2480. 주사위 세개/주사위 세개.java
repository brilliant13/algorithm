import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int price =0;
        int max =0;

        //같은 눈 3개
        if (n == m && m == l) {
            price = 10000+n*1000;
        }
        //같은 눈 2개
        else if (n == m || n == l || m == l) {
            if (n == m || n == l) {
                price = 1000 + n * 100;
            } else {
                price = 1000 + m*100;
            }
        }
        //모두 다른 눈
        else{
            int max1 = Math.max(n, m);
            max = Math.max(max1, l);
            price = max*100;
        }
        System.out.println(price);

    }
}