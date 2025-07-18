import java.util.Arrays;
class Solution {
    public String[] solution(String myString) {
        String [] arr = myString.split("x");
        //String[] -> Stream<String> -> String[] 
        return Arrays.stream(arr).filter(x->!x.equals("")).sorted().toArray(String[]::new);
        
        
    }
}