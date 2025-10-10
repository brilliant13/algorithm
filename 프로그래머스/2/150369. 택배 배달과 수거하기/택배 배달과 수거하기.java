import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    static class Node {
        int idx; //집 번호 (0-based)
        int qty; //남은 개수
        Node(int i, int q){idx =i; qty = q;}
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deque<Node> ds = new ArrayDeque<>(); //배달 스택
        Deque<Node> ps = new ArrayDeque<>(); //수거 스택
        
        for(int i=0; i<n; i++){
            if(deliveries[i]>0)ds.push(new Node(i,deliveries[i]));
            if(pickups[i]>0)ps.push(new Node(i,pickups[i]));
        }
        long answer = 0L;
        
        while(!ds.isEmpty() || !ps.isEmpty()){
            int far = -1;
            if(!ds.isEmpty()) far = Math.max(far, ds.peek().idx);
            if(!ps.isEmpty()) far = Math.max(far, ps.peek().idx);
            
            answer += (long) (far+1)*2;
            
            int give = cap;
            while(give >0 && !ds.isEmpty()){
                Node cur = ds.peek();
                int use = Math.min(cur.qty, give);
                cur.qty -= use;
                give -= use;
                if(cur.qty ==0) ds.pop(); 
            }
            
            int take = cap;
            while(take>0 && !ps.isEmpty()){
                Node cur = ps.peek();
                int use = Math.min(cur.qty, take);
                cur.qty -= use;
                take -= use;
                if(cur.qty == 0) ps.pop();
            }
        }        
        return answer;
    }
}