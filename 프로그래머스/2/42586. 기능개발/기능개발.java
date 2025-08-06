import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            int day = (100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0) day++;
            days.add(day);
        }
        
        List<Integer> deploy = new ArrayList<>();
        int preNum = days.get(0);
        int count = 1;
        
        for(int i=1; i<days.size(); i++){
            if(preNum>=days.get(i)){
                count++;
            }
            else{
                deploy.add(count);
                count = 1;
                preNum = days.get(i);
            }
        }
        if(count!=0) deploy.add(count);
        
        return deploy.stream().mapToInt(Integer::intValue).toArray();
    }
}