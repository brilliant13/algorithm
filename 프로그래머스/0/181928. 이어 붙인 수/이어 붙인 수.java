class Solution {
    public int solution(int[] num_list) {
        String odds = "";
        String evens = "";
        
        for(int val : num_list){
            if(val%2!=0) {
                odds += Integer.toString(val);
            }
            else {
                evens += String.valueOf(val);
            }
        }
        
        return Integer.parseInt(odds)+Integer.parseInt(evens);
    }
}