import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = num; i >= 1; i--) {
            sb.append(i).append('\n');
        }
        System.out.print(sb);

    }
}