import java.util.Set;
import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for(String num : phone_book){
            set.add(num);
        }
        for(String num : phone_book){
            for(int len=1; len<num.length();len++){
                if(set.contains(num.substring(0,len)))
                    return false;
            }
        }
    return true;
    }
}