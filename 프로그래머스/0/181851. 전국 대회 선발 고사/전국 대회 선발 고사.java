import java.util.Comparator;
import java.util.stream.IntStream;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        return IntStream.range(0, rank.length)
            .filter(i -> attendance[i])
            .boxed() //? IntStream -> Stream<Integer>인가?
            .sorted(Comparator.comparing(i->rank[i]))//rank[i]값 비교해서 오름차순으로 정수정렬
            .limit(3L)//L은 뭐지
            .reduce((current,next)->current*100 +next)
            .get();
    }
}