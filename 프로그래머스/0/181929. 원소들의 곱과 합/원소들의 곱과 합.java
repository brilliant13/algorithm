class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        for(int i=0; i<num_list.length; i++){
            sum += num_list[i];
            mul *= num_list[i];
        }
        return mul < sum*sum ? 1 : mul > sum*sum ? 0 : null;

    }
}