import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int [] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int from = commands[i][0];
            int to = commands[i][1];
            int k = commands[i][2];
            
            int size = to-from+1;
            int[] copy = new int[size];
            System.arraycopy(array,from-1,copy,0,size);
            Arrays.sort(copy);
            answer[i] = copy[k-1];
        }

        return answer;
    }
}