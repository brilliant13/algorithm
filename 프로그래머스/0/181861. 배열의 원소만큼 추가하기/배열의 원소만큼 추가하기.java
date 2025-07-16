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
int[] result = list.stream()
                        .mapToInt(Integer::intValue).toArray();
        return result;
    }
}