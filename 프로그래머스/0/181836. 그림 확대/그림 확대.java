class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int idx = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<k; j++){
                for(int l=0; l<picture[i].length(); l++){
                    sb.append(String.valueOf(picture[i].charAt(l)).repeat(k));
                }
                answer[idx++] = sb.toString();
                sb.setLength(0);
            }
        }
        return answer;
    }
}