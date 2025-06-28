class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String str = "";
        for(int i=0; i<finished.length; i++){
            str = !finished[i] ? str + todo_list[i]+"," : str;
        }
        
        return str.split(",");
    }
}