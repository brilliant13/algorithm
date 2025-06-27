class Solution {
    public int solution(int a, int b) {
        int aLong = Integer.parseInt(a+""+b);
        return Math.max(aLong,2*a*b);
    }
}