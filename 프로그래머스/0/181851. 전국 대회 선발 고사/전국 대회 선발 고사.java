import java.util.HashMap;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        //0~n-1번까지 학생 중 -> 3명 선발
        int[] result = new int[3];
        int count = 0;
        int last = 1;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<rank.length; i++){
            map.put(rank[i],i);
        }
        for(int i=1; i<=rank.length; i++){
            int student = map.get(i);
            if(attendance[student]){
                result[count] = student;
                count++;
            }
            if(count==3) break;
        }
        
        int answer = 10000*result[0] + 100*result[1]+ result[2];
        return answer;
    }
}