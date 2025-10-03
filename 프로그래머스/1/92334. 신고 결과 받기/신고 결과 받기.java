import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // ["muzi", "frodo", "apeach", "neo"]
        //각각에게 누가 메일 보냈는지 연결시킨다. k번 신고 들어오면, 각 이름과 연결된 리스트 들어가서 그 사람들에게 메일 보낸다. 각각 count++
        
        
        Map<String,Set<String>> reportUsers = new HashMap<>();
        Map<String,Integer> reportCount = new HashMap<>();
        
       
        // 입력값 처리: ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
        for(int i =0; i<report.length; i++){
            String[] cur = report[i].split(" "); 
            String user = cur[0];
            String target = cur[1];
            
            reportUsers.computeIfAbsent(target, v-> new HashSet<>());
            boolean added = reportUsers.get(target).add(user);
            if(added){
            reportCount.put(target, reportCount.getOrDefault(target,0) + 1 );
            }
        }
        
        //[muzi: a,b,c  frodo: a,c ..]
        int[] answer = new int[id_list.length]; //0 0 0 0 0
        
        for(int i=0; i<id_list.length; i++){
            String userName = id_list[i];
            if(reportCount.getOrDefault(userName,0)>=k){
                // a b c 각각에 +1해줘야지
                for(String name : reportUsers.getOrDefault(userName,Collections.emptySet())){
                    // a. 이름 찾아서, 이메일 카운트++
                    for(int j=0; j<id_list.length; j++){
                        if(id_list[j].equals(name)){
                            answer[j]++;
                        }
                    }
                }
            }
        }
        return answer;
    }
}