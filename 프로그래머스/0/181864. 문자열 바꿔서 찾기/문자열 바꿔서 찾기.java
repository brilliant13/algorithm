import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public int solution(String myString, String pat) {
       //기존 BAABB 와 AABB 비교
        //역 ABBAA 와 BBAA 비교
        return myString.contains(Stream.of(pat.split(""))
                                 .map(str -> "A".equals(str)?"B":"A").collect(Collectors.joining()))? 1:0 ;
            //String -> String[] -> Stream<String> ->String
    }
}