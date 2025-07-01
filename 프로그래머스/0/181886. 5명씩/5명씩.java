class Solution {
    public String[] solution(String[] names) {
        int idx = names.length/5;
        String[] answer;
        if(names.length%5==0){
            answer = new String[idx];
            for(int i=0; i<idx; i++){
                answer[i] = names[5*i];
            }
        }else {
            answer = new String[++idx];
            for(int i=0; i<idx; i++){
                answer[i] = names[5*i];
            }
        }
        return answer;
    }
}