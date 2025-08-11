class Solution {
    public int[] solution(String my_string) {
        // 아스키코드 대문자먼저 소문자다음
        // a = 97
        //32차이. 알파벳 26개인데, 6개 차이는 아스키코드 중간에 다른문자있어서.
        // A = 65
        // System.out.println((int)'A');
        int[] answer = new int[52];
        for(char ch : my_string.toCharArray()){
            if(ch>=65 && ch<=90){
                answer[ch-65]++;
            }
            else{
                answer[ch-97+26]++;
            }
        }
        return answer;
    }
}