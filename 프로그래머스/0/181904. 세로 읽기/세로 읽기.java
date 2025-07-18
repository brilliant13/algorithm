class Solution {
    public String solution(String my_string, int m, int c) {
        int N = my_string.length()/m;
        String answer = "";
        int idx = 0;
        for(int i=0; i<N; i++){
            answer += my_string.substring(idx,m+idx).charAt(c-1);
            idx+=m;
        }
        return answer;
    }
}