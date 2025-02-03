import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
//영식 //1~29초 = 10원청구 //30~59초 20원청구
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int Yp=0;
        int Bp=0;

        for (int i = 0; i < N; i++) {
            int x = arr[i]/30;
            Yp += (x + 1) * 10;
        }
//민식 // 1~59초 15원청구 // 60~119 30원청구
        for (int i = 0; i < N; i++) {
            int y = arr[i]/60;
            Bp += (y + 1) * 15;
        }
        if (Yp < Bp) {
            System.out.println("Y "+Yp);
        } else if (Bp < Yp) {
            System.out.println("M "+Bp);
        } else {
            System.out.println("Y M "+Yp);
        }

    }
}