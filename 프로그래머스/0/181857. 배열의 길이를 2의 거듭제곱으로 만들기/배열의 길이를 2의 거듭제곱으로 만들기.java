import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.copyOf(arr,(int)Math.pow(2,Math.ceil(Math.log(arr.length)/Math.log(2))));
    }
}
