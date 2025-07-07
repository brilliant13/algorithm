class Solution {
    public int solution(int n, String control) {
        
        char index = ' ';
        for(int i=0; i<control.length();i++){
            index = control.charAt(i);
            switch(index){
                case 'w' : n++; break;
                case 's': n--; break;
                case 'd' : n+=10; break;
                case 'a' : n-=10; break;
            }
        }
        
        return n;
    }
}