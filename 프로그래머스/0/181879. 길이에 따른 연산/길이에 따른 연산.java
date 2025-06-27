class Solution {
    public int solution(int[] num_list) {
        if(num_list.length >=11){
            int sum = 0;
            for(int i=0; i<num_list.length;i++){
                sum += num_list[i];
            }
            return sum;
        }
        else{
            int mul = 1;
            for(int i=0; i<num_list.length;i++){
                mul *= num_list[i];
            }
            return mul;    
        }

    }
}