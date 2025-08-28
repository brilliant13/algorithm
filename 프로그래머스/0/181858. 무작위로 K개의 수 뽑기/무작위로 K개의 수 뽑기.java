import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int k) {
        boolean[] chk = new boolean[100001];
        List<Integer> list = new ArrayList<>();
        
        int count = 0;
        for(int num : arr){
            if(!chk[num]){
                list.add(num);
                chk[num] = true;
                count++;
            }
            if(count==k) break;
        }
        // System.out.println("list = "+list.size());
        int size = list.size();
        if(size<k){
            for(int i=0; i<k-size; i++){
                // System.out.println("i = "+i);
                list.add(-1);
            }
        }
       return list.stream().mapToInt(Integer::intValue).toArray();
    }
}