class Solution {
    public int solution(int[] num_list, int n) {
        //int[] -> IntStream ->
        // return Arrays.stream(num_list).map(i->i==n?)
        for(int i=0 ;i<num_list.length; i++){
            if(num_list[i]==n) return 1;
        }
        return 0;
    }
}