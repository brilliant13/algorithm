import java.util.Arrays;

class Solution {
    public int solution(int[] num_list, int n) {
        //int[] -> IntStream ->
        return Arrays.stream(num_list).filter(i -> i==n)
                                      .count() >0 ?1 : 0;
    }
}