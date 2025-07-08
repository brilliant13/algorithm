class Solution {
    public String solution(String myString) {
        char [] chars = myString.toCharArray();
        
        for(int i=0; i<myString.length(); i++){
            if(chars[i]-'l'<0) chars[i] = 'l';
        }
        return String.valueOf(chars);  
        
    }
}