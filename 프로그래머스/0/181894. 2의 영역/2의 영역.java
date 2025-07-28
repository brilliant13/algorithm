import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            //리스트에 인덱스 집어넣기
            if(arr[i]==2) list.add(i);
        }
        
        int size = list.size();
        List<Integer> answer = new ArrayList<>();
        
        if(size == 0) answer.add(-1);
        else{
            int start = list.get(0);
            int end = list.get(size-1);
            for(int i=start; i<=end; i++){
                answer.add(arr[i]);
            }
        }
        //List<Integer> -> Stream<Integer> -> IntStream ->int[]
        //List.stream() List<Integer> -> Stream<Integer>  IntegerStream
        //Arrays.stream(int[])  int[] -> IntStream
       return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}