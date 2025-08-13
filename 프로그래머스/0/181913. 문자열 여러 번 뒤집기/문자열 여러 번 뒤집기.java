class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] chars = my_string.toCharArray();
        
        for(int i=0; i<queries.length; i++){
            int s = queries[i][0], e = queries[i][1];
            int swaps = (int)Math.ceil((double)(e-s)/2);
            for(int j=0; j<swaps; j++){
                char temp = chars[s+j];
                chars[s+j]=chars[e-j];
                chars[e-j]=temp;
            }
        }
    return new String(chars);        
    }

}