class Solution {
    public String solution(int[] numLog) {
        //numLog[0] w a s d 
        //[0,1,0,10,0,1,0,10,0,-1,-2,-1]
        String answer = "";
        for(int i=1; i<numLog.length; i++){
            if(numLog[i-1]+1 == numLog[i]) answer +="w";
            else if(numLog[i-1]-1 == numLog[i]) answer +="s";
            else if(numLog[i-1]+10 == numLog[i]) answer +="d";
            else if(numLog[i-1]-10 == numLog[i]) answer +="a";
        }
        return answer;
    }
}