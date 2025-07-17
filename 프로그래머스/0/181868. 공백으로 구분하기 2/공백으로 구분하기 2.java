import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        //String -> String[] -> Stream<String> -> String[]
        return Arrays.stream(my_string.trim().split(" ")).filter(x->!x.equals("")).toArray(String[]::new);

    }
}