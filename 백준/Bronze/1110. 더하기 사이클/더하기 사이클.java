import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cycle = 0;
        char[] arr = new char[2];
        if (N < 10) {
            arr[0] = '0';
            arr[1] = (char) (N + '0'); //정수->문자
        } else {
            arr[0] = (char)(N/10 + '0');
            arr[1] = (char) (N % 10 + '0');
        }

        char[] temp = Arrays.copyOf(arr, arr.length);

        while (true) {
            cycle++;
            int a = temp[0] - '0'; //문자->정수
            int b = temp[1] - '0';
            int ab = a+b;
            if (ab < 10) {
                temp[0] = '0';
                temp[1] = (char) (ab + '0'); //정수->문자
            } else {
                temp[0] = (char)(ab/10 + '0');
                temp[1] = (char) (ab % 10 + '0');
            }
            char[] change = new char[2];
            change[0] = (char)(b + '0');  //정수 ->문자
            change[1] = temp[1];
            if(Arrays.equals(arr, change))break;
            temp = Arrays.copyOf(change, change.length);
        }
        System.out.println(cycle);

    }
}
