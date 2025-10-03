class Solution {
    public int[][] solution(int n) {
        int[][] ans = new int[n][n];
        
        int top =0, bottom = n-1;
        int left =0, right = n-1;
        int num = 1, last = n*n;
        
        while(num <= last){
            //→ 위쪽 행
            for(int j=left; j<=right; j++) ans[top][j] = num++;
            top++;
            
             // ↓ 오른쪽 열
            for(int i=top; i<=bottom;i++) ans[i][right] = num++;
            right--;
            
            // ← 아래쪽 행
            for(int j=right; j>=left; j--) ans[bottom][j] = num++;
            bottom--;
            
            // ↑ 왼쪽 열
            for(int i=bottom; i>=top; i--)ans[i][left] = num++;
            left++;
        }
            
        return ans;
    }
}