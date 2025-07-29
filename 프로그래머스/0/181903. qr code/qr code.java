import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int q, int r, String code) {
        return IntStream.range(0,code.length()).filter(operand ->operand%q ==r)
            .mapToObj(i->String.valueOf(code.charAt(i))).collect(Collectors.joining());
            //Stream<String> -> String
    }
}