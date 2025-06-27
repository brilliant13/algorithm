class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        char [] my = my_string.toCharArray();
        char [] over = overwrite_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++){
            
            if(i==s){
                for(int j=0; j<overwrite_string.length(); j++){
                    sb.append(over[j]);
                }
                for(int k=s + overwrite_string.length(); k<my_string.length(); k++){
                    sb.append(my[k]);
                }
                break;
            }
            sb.append(my[i]);
        }
        
        String answer = sb.toString();
        return answer;
    }
}