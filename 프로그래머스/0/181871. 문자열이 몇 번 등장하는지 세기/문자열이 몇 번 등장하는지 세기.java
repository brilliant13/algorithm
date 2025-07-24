class Solution {
    public int solution(String myString, String pat) {
        int count =0;
        while(true){
            int first = myString.indexOf(pat);//인덱스가 없으면 -1 반환하나?
            if(first>=0){
                count++;
                myString = myString.substring(first+1);
            }    
            else{
                break;
            }
        }
        return count;
    }
}