import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        
        //IntStream 
        //slicer a,b,c
        
        //0~n-1
        if(n ==1)
        return IntStream.range(0,num_list.length).filter(i->i<=slicer[1]).map(i->num_list[i]).toArray();
        else if(n==2)
            return IntStream.range(0,num_list.length).filter(i->i>=slicer[0]).map(i->num_list[i]).toArray();
        else if(n==3)
            return IntStream.range(0,num_list.length).filter(i-> i>=slicer[0] && i<=slicer[1]).map(i->num_list[i]).toArray();
        else
        {
            int[] arr = IntStream.range(0,num_list.length).filter(i-> i>=slicer[0] && i<=slicer[1]).map(i->num_list[i]).toArray();
            List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i+=2){
            list.add(arr[i]);
        }
            return list.stream().mapToInt(Integer::intValue).toArray();
        
        }
    }
}