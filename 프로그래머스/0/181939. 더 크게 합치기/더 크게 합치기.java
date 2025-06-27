class Solution {
    public int solution(int a, int b) {
        String first = String.valueOf(a);
        String second = String.valueOf(b);
        int F = Integer.parseInt(first+second);
        int S = Integer.parseInt(second+first);
        
        int answer = F > S ? F : S;
        return answer;
    }
}