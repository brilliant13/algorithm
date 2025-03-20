import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1번~N번까지 N명의 사람이 원을 이루면서 앉아있다.
        //K가 주어진다. K번째 사람을 제거한다.
        //(N,K)- 요세푸스 순열
        //수를 나열하고, index 화살표 만들고, k번째를 제거한다. 제거하면서 스트링빌더에 넣어준다. 제거 후 다음 k번째를 제거한다. N번 반복하면 리스트 빈다. 이후 스트링빌더 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index =0;

        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size(); //K번째 위치 찾기
            sb.append(list.remove(index));

            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }

}
