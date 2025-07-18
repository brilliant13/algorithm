class Solution {
    public int solution(String binomial) {
        String a ="";
        String b ="";
        String op = "";
        boolean check = false;
        for(int i=0; i<binomial.length();i++){
            char ch = binomial.charAt(i);
            if(ch==' ') continue;
            
            if(ch=='+' ||ch=='-'||ch=='*') {
                // op = ch.toString();
                op = Character.toString(ch);
                check = true;
                continue;
            }
            if(!check){
                a += ch;
            }
            else if(check){
                b += ch;
            }
        }
        
        switch(op){
            case "+":return Integer.parseInt(a)+Integer.parseInt(b); 
            case "-":return Integer.parseInt(a)-Integer.parseInt(b); 
            case "*":return Integer.parseInt(a)*Integer.parseInt(b); 
            default: return 0;
        }
        
    }
}