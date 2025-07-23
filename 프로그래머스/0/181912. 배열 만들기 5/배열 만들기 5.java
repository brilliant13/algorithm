import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        //문자열 intStrs, 정수k,s,l
        //intStrs의 각 원소마다 s번째 인덱스에서 시작하는 길이 l짜리 부분 문자열을 잘라내라.
        //이때 변환된 정수값이 k보다 큰경우 배열에 담아 return하라.
        
        List <Integer> list = new ArrayList<>();
        
        for(int i=0; i<intStrs.length; i++){
            int changed = Integer.parseInt(intStrs[i].substring(s,s+l));
            if(changed > k){
                list.add(changed);
            }
        }
        //ArrayList<Integer> -> int[]
        //List<Integer>->Stream<Integer>->IntStream->int[]
        //List<Integer> -> Stream<Integer> -> IntStream -> int[]
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}