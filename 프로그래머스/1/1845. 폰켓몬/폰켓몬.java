import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        //nums/2 마리 골라야함. 종류가 최대가 되도록.
        int kinds = 0;
        Map<Integer,Integer> cntMap = new HashMap<>();
        
        for(int num : nums){
            cntMap.put(num,cntMap.getOrDefault(num,0)+1);
        }
        kinds = cntMap.keySet().size();
        int choice = nums.length/2;
        if(choice >= kinds) return kinds;
        else return choice;
    }
}