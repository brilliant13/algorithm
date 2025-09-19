import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr) {
        //이차원 정수 배열 arr이 주어진다. 
        int row = arr.length;
        int col = arr[0].length;
        
        if(row>col){
            int[][]answer = new int[row][row];
            for(int i=0; i<row; i++){
                answer[i] = Arrays.copyOf(arr[i],row);
            }
            return answer;
        }else if(row<col){
            int[][]answer = new int[col][col];
            for(int i=0; i<row; i++){
                answer[i] = Arrays.copyOf(arr[i],col);
            }
            return answer;
        }else return arr;
            
    }
}