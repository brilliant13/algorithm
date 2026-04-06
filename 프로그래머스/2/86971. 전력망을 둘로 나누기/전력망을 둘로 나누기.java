import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있다.
        // 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 한다.
        // 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 한다.
        // 차이의 절댓값이 가장 작아야겠네.
        // 송전탑의 개수 n = 9
        // 전선 정보 wires
        //[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]
        
        int abs = Integer.MAX_VALUE;
        
        // 두 전력망이 가지고 있는 송전탑 개수의 차이(절댓값)을 return하라
        //for(int i=0; i<n; i++){
        for(int i=0; i<n-1; i++){ //전선 0번부터 n-2번까지만 있는거다. 
            
            // i번째 전선은 빼고 그래프를 형성한다.
            List<Integer>[] graph = new List[n+1]; // 1-based
            for(int k=0; k<=n; k++){
                graph[k] = new ArrayList<>();
            }
            
            for(int m =0; m<n-1; m++){
                if(m==i) continue;
                int[] cur = wires[m];
                int start = cur[0], end = cur[1];
                // 무방향 그래프
                graph[start].add(end);
                graph[end].add(start);
            }
            
            List<Integer> cand = new ArrayList<>();
            boolean[] visited = new boolean[n+1]; // 1-based
            for(int p=1; p<=n; p++){
                if(visited[p]) continue;
                cand.add(bfs(graph, visited, p));
            }
            int thisAbs = Math.abs(cand.get(0)-cand.get(1));
            abs = Math.min(abs, thisAbs);   
        }

        return abs;
    }
    public int bfs(List<Integer>[] graph, boolean[] visited, int start){
        visited[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        int count = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(graph[cur].isEmpty())continue;
            
            for(int i=0; i<graph[cur].size(); i++){
                int nxt = graph[cur].get(i);
                if(visited[nxt]) continue;
                
                q.offer(nxt);
                visited[nxt] = true;
                count++;
            }
   
        }
        return count;
    }
}