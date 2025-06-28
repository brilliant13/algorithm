class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int count = 0;
        for (int i=0 ; i<finished.length; i++){
            if(!finished[i]){
                 count++;
            }
        }
        System.out.println("마치치 못한 개수 = "+count);

        String[] answer = new String[count];

        int idx =0;
        for (int i=0 ; i<finished.length; i++){
            if(!finished[i]){
                 answer[idx] = todo_list[i];
                System.out.println("마치치 못한 일 = "+ todo_list[i]);
                 idx++;
            }
        }
        return answer;
    }
}