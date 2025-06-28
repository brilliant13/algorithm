class Solution {
    public int[] solution(int[] num_list, int n) {
        
        int size = num_list.length/n;
        if(num_list.length%n !=0) size++;
        
        int [] answer = new int[size];
        
        answer[0] = num_list[0];
        
        for(int i=1; i<size; i++){
            answer[i] = num_list[n*i];
        }
        
        return answer;
    }
}