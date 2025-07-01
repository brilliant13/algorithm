import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<num_list.length-n; i++){
            list.add(num_list[n+i]);
        }
        for(int i=0; i<n; i++){
            list.add(num_list[i]);
        }
        return  list.stream().mapToInt(Integer::intValue).toArray();
        // return list.toArray(new int[0]);
       
    }
}