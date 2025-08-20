import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        //queries의 원소는 각각 하나의 query를 나타낸다. [s,e,k]
        List<String> list = new ArrayList<>();
        
        outer: for(int i=0; i<queries.length; i++){
            int[] query = Arrays.copyOfRange(arr,queries[i][0],queries[i][1]+1); //logN
            Arrays.sort(query); // nlogN
            for(int val : query){
                if(val>queries[i][2]){
                    list.add(String.valueOf(val));
                    continue outer;
                }
            }
            list.add(String.valueOf(-1));
        }
        //List<String> -> int[]
        //List<String> -> Stream<String> -> Stream(Integer) ->IntStream->int[]
        // return list.stream().mapToObj(Integer::new).mapToInt(Integer::intValue).toArray();
        return list.stream().mapToInt(Integer::parseInt).toArray();
    }
}