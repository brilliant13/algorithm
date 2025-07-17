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
        
        // 수업 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }
        
        // 수업 시작 시간순으로 정렬
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        // 강의실 배정
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];
            
            // 기존 강의실 재사용 가능한지 확인
            if (!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll(); // 기존 강의실 재사용
            }
            // 새로운 종료 시간 추가 (재사용이든 신규든)
            rooms.offer(end);
        }
        
        // 필요한 강의실 개수 = 큐의 크기 (재사용되면 어차피 poll()이후 offer() 갱신되니까)
        System.out.println(rooms.size());
    }
}