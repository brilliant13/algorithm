import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r3=n*(m%10);
        int r4=n*((m/10)%10);
        int r5=n*(m/100);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r3+r4*10+r5*100);
    }
}