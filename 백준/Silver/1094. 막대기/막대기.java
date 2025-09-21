import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        while (X > 0) {
            if((X & 1) !=0) count++;
            //cnt +=(X&1);
            X>>=1;
        }
        System.out.println(count);

    }
}
