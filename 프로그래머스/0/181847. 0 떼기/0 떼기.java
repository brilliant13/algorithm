class Solution {
    public String solution(String n_str) {
        //String.replaceFirst("0","");
        return n_str.replaceFirst("^0+","");
    }
}