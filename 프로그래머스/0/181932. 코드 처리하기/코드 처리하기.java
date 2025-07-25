class Solution {
    public String solution(String code) {
        int mode = 0;
        String ret = "";
        // String ret ="EMPTY"
        char [] codes = code.toCharArray();
        for(int i=0; i<codes.length; i++){
            if(mode==0){
                if(codes[i]=='1'){
                    mode=1;
                    continue;
                }
                if(i%2==0){
                    ret +=codes[i];
                }
            }else{
                if(codes[i]=='1'){
                    mode=0;
                    continue;
                }
                if(i%2!=0){
                    ret +=codes[i];
                }
            }
        }
        if(ret.equals("")) ret = "EMPTY";
        
        return ret;
        
    }
}