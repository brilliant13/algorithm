import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>();
        if(num_list[num_list.length -1 ]> num_list[num_list.length -2]){
            list.add(num_list[num_list.length -1 ] - num_list[num_list.length -2]);
        }else{
            list.add(num_list[num_list.length -1 ]*2);
        }
        IntStream is = list.stream().mapToInt(Integer::intValue);
        return IntStream.concat(Arrays.stream(num_list) ,is).toArray();
    }
}