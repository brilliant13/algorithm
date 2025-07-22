class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int length1 = (intervals[0][1]-intervals[0][0])+1;
        int length2 = (intervals[1][1]-intervals[1][0])+1;
        int size = length1 + length2;
        int [] answer = new int [size];

        for(int i=0; i<length1; i++){
            answer[i] = arr[intervals[0][0]+i];
        }
        for(int j=0; j<length2; j++){
            answer[length1+j] = arr[intervals[1][0]+j];
        }
        
        return answer;
    }
}