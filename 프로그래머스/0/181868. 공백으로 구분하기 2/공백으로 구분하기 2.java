import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> list = new ArrayList<>();
        char[] chars = my_string.toCharArray();
        String result = "";
        
        for(int i=0; i<my_string.length();i++){
            if(chars[i] == ' ') {
                if(!result.equals("")){
                    list.add(result);
                    result ="";
                                      }
                continue;
            }
            result +=chars[i]; 
        }
        if(!result.equals("")) list.add(result);
        
        //ArrayList<String> -> String[]
        //toArray()만으로는 안 됨. Object[]를 반환하는데 이게 바로 String[]이 될 수 없음
        //메소드 참조써라.
        return list.toArray(String[]::new);

    }
}