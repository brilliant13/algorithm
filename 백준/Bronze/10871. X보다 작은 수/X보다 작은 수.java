import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력 N, X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        //입력 수열 A
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int arr[] = new int[st2.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        //X 탐색
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < X) {
                bw.write(arr[i] + " ");
            }
        }
        br.close();
        bw.flush();
        bw.close();


    }
}


