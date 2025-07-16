import java.util.stream.IntStream;
class Solution {
    public int solution(int[] num_list) {
        // int odds = 0;
        // int evens = 0;
        int [] odds = {0};
        int [] evens = {0};
        // IntStream 0~ (num_list-1)
        IntStream.range(0,num_list.length)
            .forEach(i-> {
                     if(i%2 ==0){
                         evens[0]+=num_list[i];
                     }
                     else {
                         odds[0]+=num_list[i];
                     }
                     });
        return evens[0]>=odds[0] ? evens[0] : odds[0];
    }
}