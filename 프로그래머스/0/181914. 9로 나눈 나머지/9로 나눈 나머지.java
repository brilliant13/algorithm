class Solution {
    public int solution(String number) {
        return number.chars().map(c->(c-'0')%9).sum()%9;
    }
}