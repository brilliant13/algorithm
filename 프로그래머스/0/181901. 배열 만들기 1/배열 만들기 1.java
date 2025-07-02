import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int k) {
        // 1<= int <= n, k의 배수인 정수
        List <Integer> list = new ArrayList<>();
        for (int i=k; i<=n; i+=k){
            list.add(i);
        }
        //Stream<Integer> -> IntStream -> int[]
        int [] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}