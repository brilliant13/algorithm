class Solution {
    public int solution(String my_string, String is_suffix) {
        
        int len1 = my_string.length();
        int len2 = is_suffix.length();
        if (len2>len1) return 0;
        
        return my_string.substring((len1 - len2)).equals(is_suffix) ? 1: 0;
        
        // return my_string.contains(is_suffix) ? 1 : 0;
        
        //
    }
}