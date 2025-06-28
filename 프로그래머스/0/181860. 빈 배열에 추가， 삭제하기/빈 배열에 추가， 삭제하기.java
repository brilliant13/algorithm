import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        // arr = {3,2,4,1,3}
        // flag = {T,F,T,F,F}
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<flag.length; i++){
            if(flag[i]){
                // flag[i]가 true
                for(int j=0; j<arr[i]*2;j++)
                list.add(arr[i]);
            }else{
                list.subList(list.size()-arr[i],list.size()).clear();
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}