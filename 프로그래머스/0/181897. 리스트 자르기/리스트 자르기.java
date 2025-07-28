import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
       return IntStream.iterate(n==1 ? 0 : slicer[0], i-> i <= (n==2 ? num_list.length-1: slicer[1]), i-> n==4 ? i+slicer[2] : i+1).map(i->num_list[i]).toArray();
        
    }
}