import java.util.Arrays;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] arr, int k) {
        return IntStream.concat(
        Arrays.stream(arr).distinct(),
        IntStream.range(0,k).map(i->-1))
            .limit(k)
            .toArray();
    }
}