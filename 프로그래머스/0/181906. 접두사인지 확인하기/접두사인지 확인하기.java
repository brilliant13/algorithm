class Solution {
    public int solution(String my_string, String is_prefix) {
        //String.contains() .indexOf, .lastIndexOf, 
        if(my_string.contains(is_prefix)&&my_string.indexOf(is_prefix)==0) return 1;
        else return 0;
    }
}