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
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check_full(arr);
        System.out.println(white + "\n" + blue);
    }

    static void check_full(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        if (arr.length == 1 && arr[0].length == 1) {
            if (arr[0][0] == 1) blue++;
            else white++;
            return;
        }
        int first = arr[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != first) {
                    int mid = n/2;
                    //재귀
                    check_full(submatrix(arr, 0, 0, mid, mid));
                    check_full(submatrix(arr, 0, mid, mid, mid));
                    check_full(submatrix(arr, mid, 0, mid, mid));
                    check_full(submatrix(arr, mid, mid, mid, mid));
                    return;
                }
            }
        }
        if(first==1) blue++;
        else white++;

    }

    static int[][] submatrix(int[][] arr, int r0, int c0, int h, int w) {
        int[][] res = new int[h][w];
        for (int r = 0; r < h; r++) {
            System.arraycopy(arr[r0 + r], c0, res[r], 0, w);
        }
        return res;
    }
}