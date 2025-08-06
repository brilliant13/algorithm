import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        //[2,1,3,2]
        //[0,1,2,3]
        //인덱스를 저장하여 실행을 담당하는 큐와, 각 인덱스의 우선순위값을 저장하는, 최대힙 구조의 우선순위 큐를 자료구조로 사용하자.
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            q.offer(i);
            pq.offer(priorities[i]);
        }
        int executedCount = 0;
        while(!q.isEmpty()){
            int idx = q.poll();
            //프로세스 실행할 경우
            if(priorities[idx]>=pq.peek()){
                pq.poll();
                executedCount++;
                if(idx == location){
                    return executedCount;
                }
            }
            //프로세스를 다시 큐에 넣을 경우
            else{
                q.offer(idx);
            }
            
        }
        return -1;
        
        
    }
}