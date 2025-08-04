import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i])-1);
            map.remove(completion[i],0);
        }
         String answer = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            answer = entry.getKey();
        }
       
        return answer;
    }
}