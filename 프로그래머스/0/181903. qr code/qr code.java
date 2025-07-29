class Solution {
    public String solution(int q, int r, String code) {
        //qjnwezgrpirldywt
        // 인덱스%q ==r 인 위치의 문자를 앞에서부터 순서대로 이어 붙인
        // 처음 요소 찾고 +q씩 인덱스 늘려가면서 더하면 됨. 길이 넘지 않게.
       String answer = "";
        for(int i = r; i<code.length(); i+=q){
            // System.out.println(code.charAt(r));
            answer += code.charAt(i);
        }
        
        return answer;
    }
}