import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        //ArrayList로 add,remove하다가 마지막에 int[]로 해주자.
        List<Integer> list = new ArrayList<>();
        while(i<arr.length){
            if(list.size()==0){
                list.add(arr[i++]);
            }
            else if(list.get(list.size()-1)<arr[i]){
                list.add(arr[i++]);
            }
            else {
                list.remove(list.size()-1);
            }
        }
        //ArrayList<Integer> -> int[]
        //List<Integer> -> Stream<Integer> -> IntStream -> int[]
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}