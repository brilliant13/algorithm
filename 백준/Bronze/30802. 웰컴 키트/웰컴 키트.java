import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //티셔츠 한 장+ 펜 한 자루 포함된 웰컴키트
        //티셔츠는 같은 사이즈의 T장 묶음으로만 주문가능
        //T = 5, P=7
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //옷 사이즈 배열
        int arr[] = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //티셔즈 묶음, 펜 묶음수 입력
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        //티셔츠를 최소 몇 묶음 주문해야하는지

        int t_count =0;
        for (int i = 0; i < 6; i++) {
            t_count += (arr[i]/T)+((arr[i]%T) >0 ? 1 :0);
        }
        //펜을 최대 몇 묶음 주문할 수 있고, 한자루씩은 몇 개 주문하는지
        int p_count = N / P;
        int remainder = N % P;

        System.out.println(t_count + "\n" + p_count + " " + remainder);




    }
}