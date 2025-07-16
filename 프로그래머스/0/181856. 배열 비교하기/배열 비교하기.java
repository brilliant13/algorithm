import java.util.Arrays;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length)
            return arr1.length > arr2.length ? 1 : -1;
        if(arr1.length == arr2.length){
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            return sum1==sum2 ? 0 : (sum1> sum2 ? 1 : -1) ;
            // return sum1>sum2 ? 1 : -1;
        }
        return 0;
    }
}