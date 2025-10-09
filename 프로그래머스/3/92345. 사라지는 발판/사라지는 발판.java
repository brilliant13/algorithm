import java.util.*;

class Solution {
    static final int[] DR = {-1,1,0,0};
    static final int[] DC = {0,0,-1,1};
    
    int R,C;
    int[][] board;
    // key = 상태를 문자열로 표현 (턴, 위치, 보드 상태)
    
    static class Result{
        final boolean win;
        final int steps;
        Result(boolean w, int s){win = w; steps=s;}
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.R = board.length;
        this.C = board[0].length;
        Result res = playA(aloc[0],aloc[1],bloc[0],bloc[1]);
        return res.steps;
    }
    
    // A차례
    private Result playA(int ar, int ac, int br, int bc){
        if(board[ar][ac]==0) return new Result(false,0);
        
        //A가 이동할 수 있는 방향들
        List<int[]> moves = new ArrayList<>();
        for(int d=0; d<4; d++){
            int nr = ar +DR[d], nc = ac + DC[d];
            if(0<= nr && nr < R && 0<=nc && nc < C && board[nr][nc] ==1 ){
                moves.add(new int[]{nr,nc});
            }
        }
        if(moves.isEmpty()) return new Result(false, 0); //못 움직이면 패배
        
        // 3) 현재 칸을 사라지게 하고(move), 모든 후보로 시뮬레이션 (백트래킹)
        board[ar][ac] = 0;
        //이길 수 있으면 빨리 이겨라 -> 이길 때는 최소 steps 고름
        int bestWinSteps = Integer.MAX_VALUE;
        //질 수밖에 없으면 오래 버텨라 -> 질 때는 최대 steps 고름
        int bestLoseSteps = 0;
        boolean canWin = false;
        
        for(int[] mv: moves){
            int nr = mv[0], nc = mv[1];
            //A가 (nr,nc)로 이동한 뒤에는 B의 차례
            Result opp = playB(nr,nc,br,bc);
            // 내 이동 1걸음 포함
            int total = opp.steps + 1;
            
            //만약 상대 결과가 "패배"라면, 나는 그 수를 선택해 항상 이길 수 있음
            if(!opp.win){
                canWin = true;
                bestWinSteps = Math.min(bestWinSteps, total); //가능한 한 빨리 이김
            }else{
                //어떤 수를 두어도 상대가 이기는 상태로 가면 나는 패배 -> 오래 버팀
                bestLoseSteps = Math.max(bestLoseSteps, total);
            }
        }
        
        // 4) 백트랙킹: 보드 원복(다른 분기를 위해)
        board[ar][ac] = 1;
        
        // 5) 최종 결정: 이길 수 있는 수가 하나라도 있으면 승리(min steps), 아니면 패배(max steps)
        return canWin ? new Result(true, bestWinSteps) : new Result(false, bestLoseSteps);
    }
    
    //B의 차례 버전(로직은 A와 동일, 역할만 뒤바뀜)
    private Result playB(int ar, int ac, int br, int bc){
        if(board[br][bc]==0) return new Result(false,0);
        
        List<int[]> moves = new ArrayList<>();
        for(int d =0; d<4; d++){
            int nr= br+DR[d], nc = bc+DC[d];
            if(0<=nr && nr <R && 0<=nc && nc < C && board[nr][nc]==1){
                moves.add(new int[]{nr,nc});
            }
        }
        if(moves.isEmpty()) return new Result(false,0); //이동불가 -> 패배
        
        //현재 B의 발밑 지움
        board[br][bc] = 0;
    
        int bestWinSteps = Integer.MAX_VALUE;
        int bestLoseSteps = 0;
        boolean canWin = false;
        
        for(int[]mv : moves){
            int nr = mv[0], nc = mv[1];
            
            //B가 이동 후에는 A 차례
            Result opp = playA(ar,ac,nr,nc);
            int total = opp.steps +1;
            
            if(!opp.win){
                canWin = true;
                bestWinSteps = Math.min(bestWinSteps, total);
            }else {
                bestLoseSteps = Math.max(bestLoseSteps, total);
            }
        }
        
        board[br][bc] = 1;
        return canWin ? new Result(true, bestWinSteps) : new Result(false, bestLoseSteps);
    }
}