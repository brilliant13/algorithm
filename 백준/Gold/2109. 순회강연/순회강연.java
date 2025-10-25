import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        //5:10 ~
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //거꾸로 채우면 그리디 가능 . 탐욕적으로. 가장 최적의 선택만. 다시 돌이키지않음.

        ArrayList<Integer>[] byDeadLine = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) byDeadLine[i] = new ArrayList<>();

        int maxD = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            byDeadLine[d].add(p);
            if(d>maxD) maxD = d;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
        long ans = 0;

        for (int day = maxD; day > 0; day--) {
            //day까지 마감인 강연들을 후보에 추가
//            for (int pay : byDeadline[day]) pq.add(pay);
            pq.addAll(byDeadLine[day]);
            if(!pq.isEmpty()) ans += pq.poll();
        }

        System.out.println(ans);


    }
}

