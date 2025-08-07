import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        //다리 크기 만큼 '0' offer() 초기화
        for(int i=0; i<bridge_length; i++){
            q.offer(0);
        }
        int curWeight = 0;
        int i = 0;
        
        while(i<truck_weights.length){
            int val = q.poll();
            curWeight -= val;
            if(curWeight+truck_weights[i] <= weight){
                q.offer(truck_weights[i]);
                curWeight += truck_weights[i++];
            }
            else{
                q.offer(0);
            }
            time++;
        }
        return time+bridge_length;
        

    }
}