class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<index_list.length; i++){
            sb.append(my_string.charAt(index_list[i])); 
        }
        answer = sb.toString();
        return answer;
    }
}