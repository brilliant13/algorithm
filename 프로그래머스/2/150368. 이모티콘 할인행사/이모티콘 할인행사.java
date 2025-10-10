import java.util.Arrays;

class Solution {
    //최적 결과: [가입자 수, 매출액]
    int[] best = new int[2];
    int[][]users; //[최소할인%, 기준가격]
    int[] prices; //이모티콘 가격
    int m; //이모티콘 개수
    int[] picked; //각 이모티콘에 적용할 할인(%) 저장
    static final int[] CHOICES = {10,20,30,40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;// [[40, 10000], [25, 10000]]
        this.prices = emoticons; //[7000, 9000]
        this.m = emoticons.length;
        this.picked = new int[m]; //dfs에서 sequence배열. 해당 조합이 완성되었을 때 평가 함수에 넣을 대상.
        
        dfs(0); // 이모티콘 할인율 전부 시도 (4^m);
        
        return best; //[가입자수 최대, (동률 시) 매출 최댓값)]
    }
    //idx번째 이모티콘의 할인률 정하는 DFS. depth가 깊어지면서 선택하던 거랑 유사. 즉 조합을 만드는 것이다. 엄밀히 말하면 할인률 4가지 들의 중복순열. 4파이7 서로다른 4개(서로 다른 4개의 할인율)를 중복을 포함해 7개(이모티콘 최대 개수) 뽑는다.
    private void dfs(int idx){
        if(idx==m){
            evaluate(); //모든 할인률 선택 완료 -> 점수 계산
            return;
        }
        for(int d : CHOICES){
            picked[idx] = d;
            dfs(idx+1);
        }
    }
    
    //하나의 수열이 완성됨. 하나의 조합이 완성됨. 4^M개중 하나의 중복순열이 완성된 것임. 그걸 평가 함수에 넣어서 전역 평가에 반영
    private void evaluate(){
        int subs = 0;
        int revenue = 0;
        
        for(int[] u : users){
            int minDisc = u[0]; //유저 최소 할인 기준(%)
            int limit = u[1]; //플러스 가입 기준 금액
            int sum = 0;
            
            //할인율이 기준 이상인 이모티콘만 구매
            for(int i=0; i<m; i++){
                if(picked[i]>=minDisc){
                    int disc = picked[i];
                    int discounted = prices[i]*(100-disc)/100;//왼쪽에서 -> 오른쪽으로 우선순위 계산. 가격은 100의배수
                    sum += discounted;
                }
            }
            
            if(sum>=limit)subs++; //플러스 가입
            else revenue += sum; //매출에 더함
        }
        
        //최적 갱신: 가입자 수 우선, 동률이면 매출 큰 쪽
        if(subs> best[0]){
            best[0] = subs;
            best[1] = revenue;
        }else if (subs==best[0] && revenue > best[1]){
            best[1] = revenue;
        }
    }
}