import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(arr, 0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    static void solve(int[][] a, int r0, int c0, int n) {
        if (n == 1) {
            if(a[r0][c0]==1) blue++; else white++;
            return;
        }
        int first = a[r0][c0];
        boolean same = true;
        outer:
        for (int i = r0; i < r0 + n; i++) {
            for (int j = c0; j < c0 + n; j++) {
                if(a[i][j] != first){same = false; break outer;}
            }
        }
        if (!same) {
            int h = n/2;
            solve(a,r0,c0,h);
            solve(a, r0, c0 + h, h);
            solve(a, r0 + h, c0, h);
            solve(a, r0 + h, c0 + h, h);
            return;
        }
        if(first==1) blue++; else white++;
    }
}