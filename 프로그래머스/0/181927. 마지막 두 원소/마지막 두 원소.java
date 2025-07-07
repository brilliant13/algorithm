import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;


class Solution {
    public int[] solution(int[] num_list) {
        int last = num_list[num_list.length -1];
        int secondLast = num_list[num_list.length -2];
        
        int newValue = last > secondLast ? last - secondLast : last*2;
        
        return IntStream.concat(
                        Arrays.stream(num_list), IntStream.of(newValue)
        ).toArray();
        
    }
}