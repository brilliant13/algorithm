import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while(n!=1){
            if(n%2==0) n /=2;
            else n = 3*n+1;
            list.add(n);
        }
        int [] answer = list.stream().mapToInt(Integer::intValue).toArray();
            
        //Arrays.stream(arr)
        // List.stream().mapToInt(Integer::intValue).toArray();
        //Stream<Integer> -> IntStream -> toArray()
            
            
        return answer;
    }
}