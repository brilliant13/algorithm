import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        return Arrays.stream(intervals).flatMapToInt(ints->Arrays.stream(Arrays.copyOfRange(arr,ints[0],ints[1]+1))).toArray();
        //int[][] -> Stream<int[]> -> IntStream -> int[]
        
    }
}