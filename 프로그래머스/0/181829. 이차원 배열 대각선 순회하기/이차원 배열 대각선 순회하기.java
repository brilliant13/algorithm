class Solution {
    public int solution(int[][] board, int k) {
        //brute force로 다 해보면 되는 거 아닌가?
        int answer = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i+j <= k){
                    answer += board[i][j];
                }
            }
        }
        return answer;
    }
}