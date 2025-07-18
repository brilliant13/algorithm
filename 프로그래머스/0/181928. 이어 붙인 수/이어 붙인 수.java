import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] num_list) {
        //int[] => IntStream -> Stream<String>->String
       String odd = Arrays.stream(num_list).filter(x -> x%2 != 0)
           .mapToObj(String::valueOf)
           .collect(Collectors.joining());
  //int[] -> IntStream -> Stream<String> -> String
        String even = Arrays.stream(num_list).filter(x-> x%2 ==0)
            .mapToObj(String::valueOf).collect(Collectors.joining());
    return Integer.parseInt(odd) + Integer.parseInt(even);        
    }
}