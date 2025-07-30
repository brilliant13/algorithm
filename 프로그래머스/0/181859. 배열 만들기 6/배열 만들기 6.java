import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        //[0,1,1,1,0]
        //i의 초기값 0  i < arr.length 5
        //arr[0]을 stk에 추가  [0,]   i=1
        //i=1  arr[1] != 0   arr[1]추가   [0,1]
        //i=2 arr[2] 1, -> [0,] i=3
        //i=3 arr[3] 1, -> [0,1] i =4
        //i=4 arr[4] 0, -> [0,1,0] i=5
        //i==5 -> 조건 통과x
        int i = 0;
        List<Integer> stk = new ArrayList<>();
        while(i<arr.length){
            if(stk.size() ==0 ) {
                stk.add(arr[i]);
                i++;
            }else if(stk.get(stk.size()-1) == arr[i]){
                stk.remove(stk.size()-1);
                i++;
            }else{
                stk.add(arr[i]);
                i++;
            }
        }
        //List<Integer> ->Stream<Integer> -> IntStream ->int[]
        return stk.size() == 0 ? new int[]{-1} : stk.stream().mapToInt(Integer::intValue).toArray();
    }
}