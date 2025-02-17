import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int p_length = p.length();
        int t_length = t.length();
        long p_num = Long.parseLong(p);
        
        String sub =p;
        int split = t_length-(p_length-1);
        for(int i=0; i<split; i++){
            sub = t.substring(i,i+p_length);
            long l = Long.parseLong(sub);
            if(l<=p_num) answer++;
        }
        return answer;
    }
}