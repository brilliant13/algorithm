import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //maxHeap: 작은 절반 (큰 수가 우선순위 - 내림차순)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //minHeap: 큰 절반 (작운 수가 우선순위 - 오름차순)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            //새로운 수를 적절한 힙에 삽입한다.
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            //힙 크기 균형 맞추기
            // maxHeap 크기가 minHeap보다 2개 이상 크면 안왼다.
            if(maxHeap.size() > minHeap.size() +1){
                minHeap.offer(maxHeap.poll());
            }
            // minHeap 크기가 maxHeap보다 크면 안됨
            else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            //중앙값은 항상 maxHeap의 top
            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.print(sb);
    }

}
