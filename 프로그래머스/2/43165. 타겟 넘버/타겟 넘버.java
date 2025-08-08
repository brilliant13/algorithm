class Solution {
    private int answer = 0;
    private int[] numbers;
    private int target;
    private int n;
    // private boolean[] used;
    
    public int solution(int[] numbers, int target) {
        //전역 변수에 저장
        this.n = numbers.length;
        this.numbers = numbers;
        this.target = target;
        //깊이(depth)=0, 합(sum)=0부터 DFS 시작        
        dfs(0,0); 
        return answer;
    }
    
    private void dfs(int depth, int sum){
        if(depth==n){
            if(sum==target) answer++;
            return;
        }
        dfs(depth+1,sum+numbers[depth]);
        dfs(depth+1,sum-numbers[depth]);
    }

    
}