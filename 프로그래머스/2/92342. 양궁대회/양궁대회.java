class Solution {
    // 가장 큰 점수 차이로 이기기 위해서 -> 각 과녁마다 apeach[i]+1로 이기거나 or 0발 쏴서 SKIP하거나. 둘 중 하나
    int[] apeach; //어피치의 화살 배치
    int n; //라이언의 화살 개수
    int bestDiff; //현재까지의 최대 점수 차이
    int[] best; //최적의 화살 배치(기본은 [-1], 즉 무조건 지는 경우)
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.apeach = info;
        bestDiff = -1;
        best = new int[]{-1}; //초기화
        
        int[] ryan = new int[11]; //라이언이 쏠 화살 배치 (0~10점)
        dfs(0,n,0,ryan);
        
        //점수 차이가 0이하라면 이길 수 없음
        if(bestDiff <=0) return new int[]{-1};
        return best;
    }
    
    void dfs(int i, int left, int diff, int[] ryan){
        //모든 점수 칸(0~10)을 다 처리했을 때
        if(i==11){
            //남은 화살은 전부 0점(인덱스 10)에 몰아줌
            ryan[10] += left;
            updateBest(diff, ryan);
            ryan[10] -=left; //원상복구 (백트랙킹)
            return;
        }
        
        int score = 10-i; //현재 칸의 점수 (i=0 -> 10점, i=10 -> 0점)
        int need = apeach[i] +1; //이 점수를 따려면 필요한 최소 화살 수
        
        // 1) 현재 점수를 따는 경우 (WIN)
        if(left >=need){
            ryan[i] = need;
            dfs(i+1,left-need,diff+score,ryan);
            ryan[i] = 0; //되돌리기 (백트랙킹))
        }
        
        //2) 현재 점수를 버리는 경우 (SKIP) (라이언은 화살 안 쏨)
        //어피치가 이 칸에서 >=1발 맞췄다면 어피치가 점수를 가져감 -> diff에서 뺴줌
        int delta = (apeach[i] >0) ? -score : 0;
        ryan[i] = 0;
        dfs(i+1,left,diff+delta,ryan);
    }
    
    void updateBest(int diff, int[] cand){
        //라이언이 이기지 못하면 무시
        if(diff <=0) return;
        
        //더 큰 점수차 발견 -> 무조건 갱신
        if(diff > bestDiff){
            bestDiff = diff;
            best = cand.clone();
        }
        
        //점수 차이가 같으면 "낮은 점수 화살을 더 많이 쏜 해답" 선택
        else if(diff==bestDiff){
            if(betterLowScoreHeavier(cand, best)){
                best = cand.clone();
            }
        }
    }
    
    //타이브레이커 비교
    //낮은 점수(0점부터) 더 많이 맞힌 해답을 선택
    //배열을 뒤에서부터 (인덱스 10 -> 0) 비교
    boolean betterLowScoreHeavier(int[] cand, int[] curBest){
        for(int i=10; i>0; i--){
            if(cand[i] !=curBest[i]){
                return cand[i] > curBest[i];
            }
        }
        return false; //완전히 동일
    }
}