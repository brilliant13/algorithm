class Solution {
    public String solution(String myString, String pat) {
        //문자열 myString, pat
        //String.first  String.end 무엇으로 끝나는거 메소드 있었는데
        //String.indexOf
        
        int idx = myString.lastIndexOf(pat);
        return myString.substring(0,idx+pat.length());
    }
}