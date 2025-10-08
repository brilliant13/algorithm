import java.util.*;

class Solution {
    int maxSheep = 0;
    List<Integer>[] children;
    int[] info;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        int n = info.length;
        
        children = new ArrayList[n];
        for(int i=0; i<n; i++)children[i] = new ArrayList<>();
        for(int[]e : edges) children[e[0]].add(e[1]);
        
        //루트 0부터 시작: 후보 = [0]
        List<Integer> start = new ArrayList<>(Arrays.asList(0));
        dfs(0,0,0,start);
        
        return maxSheep;
    }
    
    // DFS(현재 노드, 양의 수, 늑대 수, 다음으로 방문할 수 있는 후보 집합)
    void dfs(int cur, int sheep, int wolf, List<Integer>candidates){
        //현재 노드 반영: xor 트릭
        sheep += info[cur] ^ 1;
        wolf += info[cur];
        
        if(wolf >= sheep) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> next = new ArrayList<>(candidates);
        next.remove(Integer.valueOf(cur));
        next.addAll(children[cur]);
        
        for(int nxt : next){
            dfs(nxt,sheep,wolf,next); //갱신된 후보 넘김
        }
        
    }
        
}