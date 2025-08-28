import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        
        List<String> list = new ArrayList<>();
        for(String str : picture){
            String temp = "";
            for(int i=0; i<str.length(); i++){
                for(int j=0; j<k; j++){
                temp += str.charAt(i);
                }
            }
            for(int j=0; j<k; j++){
            list.add(temp);
            }
        }
        return list.stream().toArray(String[]::new);
    }
}