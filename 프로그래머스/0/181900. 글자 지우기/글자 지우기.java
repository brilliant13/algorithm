import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        // // StringBuilder sb = new StringBuilder();
        // char [] chars = my_string.toCharArray();
        // for(int i=0; i<indices.length; i++){
        //     chars[indices[i]]=' ';
        // }
        // //char[] -> String
        // String answer = String.valueOf(chars);
        // return answer.replace(" ","");

        StringBuilder sb =new StringBuilder(my_string);
        Arrays.sort(indices);
        
        for(int i=indices.length -1; i>=0; i--){
            sb.deleteCharAt(indices[i]);
        }
        return sb.toString();
        
        
        
    }
}