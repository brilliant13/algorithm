import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();
        long abs = Math.abs(X - Y);
        System.out.println(abs);

    }
}