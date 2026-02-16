import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int cnt = 0;
            for (int i = 0; i < a.length(); i++)
                if (a.charAt(i) != b.charAt(i)) cnt++;
            System.out.println("Hamming distance is " + cnt + ".");
        }
    }
}