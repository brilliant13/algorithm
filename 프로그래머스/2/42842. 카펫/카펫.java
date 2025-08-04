class Solution {
    public int[] solution(int brown, int yellow) {
        int x =0, y=0;
        int width =0, height =0;
        
        for(int i=yellow; i>=Math.sqrt(yellow); i--){
            //약수가 아니면 pass
            if(yellow%i!=0) continue;
            
            //약수이면
            x = i+2;
            y = (yellow/i) +2;
            
            //조건1 (2x+2y)-4 = brown
            if(2*(x+y) != brown + 4 ) continue;
            
            //조건2 (x>=y)
            if(x<y) continue;
            
            width = x;
            height = y;
            return new int[]{width,height};
            
        }
        return new int[]{-1,-1};
    }
}