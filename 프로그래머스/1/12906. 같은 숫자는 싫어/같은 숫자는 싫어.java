import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue <Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr){
            if(q.isEmpty()) {
                q.offer(num);
            }
            else{
                // System.out.println(q.peek());
                if(q.peek() != num) {
                    list.add(q.poll());
                    q.offer(num);}
            }
        }
        list.add(q.poll());
        // Integer[] temp = q.toArray(new Integer[0]);
        
        //Integer -> Stream<Integer> -> IntStream -> int[]
        // int[] answer = Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        
        //List<Integer> -> int[]
        // List<Integer> -> Stream<Integer> -> IntStream -> int[]
        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}