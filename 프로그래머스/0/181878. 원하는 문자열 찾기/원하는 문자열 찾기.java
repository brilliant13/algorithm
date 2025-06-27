class Solution {
    public int solution(String myString, String pat) {
        
        String src = myString.toLowerCase();
        String target = pat.toLowerCase();
        return (src.contains(target))? 1 : 0 ;        
        
        


        
    }
}