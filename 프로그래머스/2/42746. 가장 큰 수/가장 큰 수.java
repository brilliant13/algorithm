import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        //int[] -> IntStream -> Stream<String> -> String
        String answer = Arrays.stream(numbers).mapToObj(String::valueOf)
            .sorted((a,b)->(b+a).compareTo(a+b))
            .collect(Collectors.joining());
        
        return answer.charAt(0) == '0' ? "0" : answer;

        // String answer = Arrays.stream(numbers)  // int[] -> IntStream
        //                       .mapToObj(String::valueOf) //IntSteram->Stream<String>
        //                       .sorted((a,b)->(b+a).compareTo(a+b)) //Stream<String> 내림차순 정렬됨
        //                       .collect(Collectors.joining()); //Stream<String> -> String
        
        
        // return answer.charAt(0) == '0' ? "0" : answer;

    }
}