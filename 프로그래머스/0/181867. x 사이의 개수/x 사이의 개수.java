import java.util.*;

class Solution {
    public int[] solution(String myString) {

        List<Integer> list = new ArrayList<>();
        
        int count =0;
        char [] chars = myString.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == 'x') {
                list.add(count);
                count = 0;
            }            
            else {
                count++;
            }
        }
        if(chars[chars.length-1]=='x')list.add(count);
        if(chars[chars.length-1]!='x') list.add(count);
        // list -> int[]
        //list.toArray()
        // return list.toArray();
        int [] result = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
        
    }
}