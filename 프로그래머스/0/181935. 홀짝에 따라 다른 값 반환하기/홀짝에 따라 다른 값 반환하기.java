class Solution {
    public int solution(int n) {
        int sum =0;
        if ( n%2 !=0){
            for(int i =1; i<=n; i=i+2){
                sum+=i;
            }
        }
        else {
            for(int i=2; i<=n; i=i+2){
                sum+=i*i;
            }
        }
        return sum;
    }
}