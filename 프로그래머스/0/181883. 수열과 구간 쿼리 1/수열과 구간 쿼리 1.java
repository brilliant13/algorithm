class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int size = queries.length; //행의 길이
        for (int i =0; i<size; i++){
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                arr[j]++;
            }
        }
        return arr;
        
    }
}