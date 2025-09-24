import java.util.List;
import java.util.ArrayList;
// import java.util.Comparator;
import java.util.Collections;

class Solution {
    int l,r;
    List<Integer> answer = new ArrayList<>();
    public int[] solution(int l, int r) {
        this.l = l;
        this.r = r;
        dfs(5);
        // answer.sort(Comparator.naturalOrder());
        Collections.sort(answer);
        if(answer.size()==0) return new int[]{-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
    private void dfs(int num){
        if(num>r)return;
        if(num>=l)answer.add(num); //5 50 500 505 55 550 555
        dfs(num*10);//50
        dfs(num*10+5);//55
    }
}
