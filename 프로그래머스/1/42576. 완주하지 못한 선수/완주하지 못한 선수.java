import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String p : participant){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        for(String c : completion){
            int v = map.get(c) -1;
            if(v==0){
                map.remove(c);
            } else {
                map.put(c,v);
            }
        }
        return map.keySet().iterator().next();
    }
}