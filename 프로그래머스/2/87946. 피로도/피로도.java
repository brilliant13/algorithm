class Solution {
    private int maxCount = 0;
    
    private int kGlobal;
    private int[][] dungeons;
    private int n;
    
    public int solution(int k, int[][] dungeons) {
        this.kGlobal = k;
        this.dungeons = dungeons;
        this.n = dungeons.length; //던전 개수
        
        boolean[] used = new boolean[n];
        int[] order = new int[n];
        
        //depth=0부터 시작해서 "던전 순서(order)를 만드는 재귀" 호출
        permute(0, used, order);
        
        //전수 탐색(permutation)으로 구한 최대 개수를 반환
        return maxCount;
    }
    //재귀 함수 permute : "던전 인덱스 0~n-1의 모든 순열"을 하나씩 만들어내는 역할
    //depth: 지금까지 order[0..depth-1]까지 채워진 상태를 의미
    //used: 각 던전이 order[]에 이미 포함됐는지 표시하는 배열
    //order: 완성된 순열을 담아두는 배열
    private void permute(int depth, boolean[] used, int[] order){
        if(depth ==n){
            simulate(order);
            return;
        }
        for(int i=0; i<n; i++){
            if(!used[i]){
                used[i] = true;
                order[depth] = i;
                
                permute(depth+1,used,order);
                
                used[i] = false;
            }
        }
    }
    
    //simulate: "완성된 순열(order[])"을 한 번 따라가며
    // 남은 피로도로 몇 개 던전을 돌 수 있는지 세고 maxCount 갱신
    private void simulate(int[] order){
        int curPiro = kGlobal;
        int count = 0;
        
        for(int idx : order){
            int need = dungeons[idx][0];
            int spend = dungeons[idx][1];
            
            if(curPiro < need) break;
            
            curPiro -= spend;
            count++;
        }
        if(count>maxCount){
            maxCount =count;
        }
    }
}