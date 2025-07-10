import java.util.stream.IntStream;
// import java.util.Collections;
import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String answer = Arrays.stream(numbers)  // int[] -> IntStream
                              .mapToObj(String::valueOf) //IntSteram->Stream<String>
                              .sorted((a,b)->(b+a).compareTo(a+b)) //Stream<String> 내림차순 정렬됨
                              .collect(Collectors.joining()); //Stream<String> -> String
        
        
        return answer.charAt(0) == '0' ? "0" : answer;

    }
}