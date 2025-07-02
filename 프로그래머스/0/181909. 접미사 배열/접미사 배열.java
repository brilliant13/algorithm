import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    public String[] solution(String my_string) {
        List <String> list = new ArrayList<>();
        for(int i=0; i<my_string.length(); i++){
            list.add(my_string.substring(my_string.length()-1-i,my_string.length()));
        }        
        Collections.sort(list); // List<String> ->String[]
        String[] result = list.stream().toArray(String[]::new);
        return result;
    }
}