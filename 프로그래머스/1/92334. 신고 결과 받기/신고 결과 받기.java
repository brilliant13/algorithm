import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //String[] -> Stream<String> -> ArrayList
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String,Integer> count = new HashMap<>();
        for(String s : list){
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target,0)+1);
        }
        //map()은 객체 스트림을 다른 타입의 객체스트림으로 바꿔줌. Stream<String>->Stream<Integer> 등으로
        //String[] -> Stream<String> -> count() 숫자반환 ?
        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s->s.startsWith(user + " ")).collect(Collectors.toList()); 
            return reportList.stream().filter(s->count.getOrDefault(s.split(" ")[1],0)>=k).count();      
        }).mapToInt(Long::intValue).toArray();
    }
}