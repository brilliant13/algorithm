import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<delete_list.length; j++){
                if(arr[i]==delete_list[j]) list.add(arr[i]);
            }
        }

        return Arrays.stream(arr)
            .filter(x-> !Arrays.stream(delete_list).anyMatch(remove -> remove == x))
            .toArray();

    }
}