import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<int[]> list = new ArrayList<>();

        //수업 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        //수업 시작 시간순으로 정렬
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        int count =0;

        //강의실 배정
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i=0; i<list.size(); i++){
            if(rooms.isEmpty() || list.get(i)[0]<rooms.peek() ){
                rooms.offer(list.get(i)[1]);
                count++;
            }
            else{
                rooms.poll();
                //강의 종료시간 갱신
                rooms.offer(list.get(i)[1]);
            }
        }

        System.out.println(count);


    }





}
