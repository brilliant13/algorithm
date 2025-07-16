import java.util.stream.IntStream;
class Solution {
    public int solution(int[] num_list) {
        int evens = IntStream.range(0,num_list.length).filter(i->i%2==0)
            .map(i->num_list[i])
            .sum();
        int odds = IntStream.range(0,num_list.length).filter(i->i%2!=0)
            .map(i->num_list[i])
            .sum();
        return Math.max(evens,odds);
    }
}