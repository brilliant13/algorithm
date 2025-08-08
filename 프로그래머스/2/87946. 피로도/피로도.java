class Solution {
    
    private int maxCount =0;
    private int kGlobal;
    private int [][] dungeons;
    private int n;
    
    public int solution(int k, int[][] dungeons) {
        this.kGlobal = k;
        this.dungeons = dungeons;
        this.n = dungeons.length;
        
        boolean[] used = new boolean[n];
        int[] order = new int[n];
        
        permute(0,used,order);
        return maxCount;
    }
    private void permute(int depth, boolean[] used, int[] order){
        if(depth==n){
            simulate(order);
            return;
        }
        for(int i=0; i<n;i++){
            if(!used[i]){
                used[i] = true;
                order[depth] = i;
                permute(depth+1,used,order);
                used[i] = false;
            }
        }
    }
    
    private void simulate(int[] order){
        int curPiro = kGlobal;
        int count = 0;
        
        for(int idx:order){
            int need = dungeons[idx][0];
            int spend = dungeons[idx][1];
            
            if(curPiro<need) break;
            
            curPiro -= spend;
            count++;
        }
        if(count>maxCount){
            maxCount = count;
        }
    }
}