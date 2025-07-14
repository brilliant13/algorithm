class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char [] arr = num_str.toCharArray();
        for (char ch : arr){
            System.out.println(ch-'0');
            answer += (ch - '0') ;
        }
        return answer;
    }
}