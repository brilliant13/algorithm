import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        
        for(int i=0; i<speeds.length; i++){
            double remain = (100-progresses[i]) / (double)speeds[i] ;
            int date = (int)Math.ceil(remain);
            
            if(!q.isEmpty() && q.peek() < date){
                //새 그룹 만들어야 함
                answerList.add(q.size());
                q.clear();
            }
            q.offer(date);
        }
        
        answerList.add(q.size());
        
        //List<Integer> -> Stream<Integer> -> IntStream -> int[]
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}