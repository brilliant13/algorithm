class Solution {
    public int solution(String number) {
        int sum = 0;
        for (char each : number.toCharArray()){
            sum += Integer.parseInt(""+each);
        }
        return sum%9;
    }
}