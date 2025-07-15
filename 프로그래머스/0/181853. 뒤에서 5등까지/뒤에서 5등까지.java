import java.util.Arrays;
class Solution {
    public int[] solution(int[] num_list) {
        //Stream API 활용
        //IntStream -> 1 4 12 14 15 38 46 -> 
        return Arrays.stream(num_list).sorted().limit(5).toArray();

    }
}