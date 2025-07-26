import java.util.Arrays;

class Solution {
    public int solution(String[] strArr) {
        //문자열 배열 strArr
        int [] groupCount = new int [31]; //1~30
        
        int max = 0;
        
        for(int i=0; i<strArr.length; i++){
            int count = strArr[i].length();
            groupCount[count]++;
        }
        //int[]에서 최댓값 찾는 법 
        //int[] -> Stream<Integer> ->
        // return Arrays.stream(groupCount).mapToInt(Integer::intValue).max().getAsInt();
        return Arrays.stream(groupCount).max().getAsInt();
        // return Arrays.stream(groupCount).max().orElse(-1);
    }
}