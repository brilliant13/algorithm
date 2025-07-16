import java.util.Arrays;

class Solution {
    public String[] solution(String[] strArr) {
        //Stream<String> -> String -> String[]
        return Arrays.stream(strArr).filter(i -> !i.contains("ad") )
                             .toArray(String[]::new);
    }
}