import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        // list = Arrays.asList(arr);
        for (int num : arr){
            for(int i=0; i<num; i++){
                list.add(num);
            }
        }
        // list -> int[]
        // return list.toArray();
        int [] result = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}