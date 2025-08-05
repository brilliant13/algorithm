import java.util.Arrays;

class Solution {
    public String[] solution(String[] str_list) {
        //String[] -> String 
        //String[] -> Stream<String> -> collect(Collectors.joingning())
        //String ->String[] // String.split("") ->String[]반환
        int idx_l = -1;
        int idx_r = -1;
        
        for(int i =0; i<str_list.length; i++){
            if(str_list[i].equals("l")){
                idx_l = idx_l == -1 ? i : idx_l;
            }       
            if(str_list[i].equals("r")){
                idx_r = idx_r == -1 ? i : idx_r;
            }   
        }
        
        // System.out.println(idx_l)
        ;
        
        String answer ="";
        if(idx_l==-1 && idx_r==-1) return new String[]{};
        
        //l만 있거나 (l먼저)
        if(idx_l != -1 && (idx_r == -1 || idx_l < idx_r)){
            return Arrays.copyOfRange(str_list,0,idx_l);
        }
        
        //r만 있거나 (r먼저)
        if(idx_r != -1 && (idx_l == -1 || idx_r < idx_l)){
            return Arrays.copyOfRange(str_list,idx_r+1,str_list.length);
        }
    
        return new String[0];
    }
}