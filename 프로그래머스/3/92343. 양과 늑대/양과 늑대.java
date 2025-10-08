import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

class Solution {
    int maxSheep = 0; //최대 양의 수
    List<Integer>[] children; //각 노드의 자식 노드 리스트 (인접 리스트)
    int[] info; //노드별 정보 (0=양,1=늑대)
    
    
    public int solution(int[] info, int[][] edges) {
        //[0,0,1,1,1,0,1,0,1,0,1,1]
        this.info = info; //전역변수로 저장 (DFS에서 계속 사용)
        int n = info.length;
        
        //자식 노드들을 담을 리스트 배열 초기화
        children = new ArrayList[n];
        for(int i=0; i<n; i++) children[i] = new ArrayList<>();
        
        //주어진 edges 정보를 바탕으로 인접 리스트 채우기
        for(int[] e : edges){
            children[e[0]].add(e[1]); //부모->자식 연결
        }
        
        //루트 노드(0)부터 시작. 초기 후보 리스트는 [0] 하나뿐
        dfs(0,0,0,new ArrayList<>(Arrays.asList(0)));
        
        return maxSheep;

    }
    void dfs(int sheep, int wolf, int node, List<Integer> candidates){
        //현재 노드가 양이면 sheep++, 늑대면 wolf++
        if(info[node]==0)sheep++;
        else wolf++;
        
        //늑대 수 >= 양 수 -> 양이 다 잡아먹힘 -> 탐색 종료
        if (wolf >= sheep) return;
        
        // 최대 양 수 갱신
        maxSheep = Math.max(maxSheep,sheep);
        
        // 다음 후보 리스트 준비
        List<Integer> next = new ArrayList<>(candidates);
        next.remove(Integer.valueOf(node)); //이번에 방문한 노드 제거
        next.addAll(children[node]); //현재 노드의 자식들을 후보에 추가
        
        //후보 노드들 중 하나씩 선택해서 DFS 계속
        for(int nxt : next){
            dfs(sheep,wolf,nxt,next);
        }
        
    }
}