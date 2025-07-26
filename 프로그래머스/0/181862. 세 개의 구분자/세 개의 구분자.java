import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        //a,b,c delimeter
        //bac onlettu c etom a to

        String sec = "";
        List<String> list = new ArrayList<>();
        int mode = 0;
        
        for(int i=0; i<myStr.length(); i++){
            if(myStr.charAt(i)=='a' ||myStr.charAt(i)=='b' || myStr.charAt(i)=='c'){
                list.add(sec);
                sec ="";
                continue;
            }
            else{
                sec += myStr.charAt(i);
            }
        }
        if(!sec.equals("")) list.add(sec);
        // ["", "", "", onlettu, etom,to]
        //List<String> -> Stream<String> -> String[] Stream에서 바로 배열가능?
        //list는 toArray로 바로되고 Arrays.stream()은 mapToObject(String::new)
        //(new String[0])이게 list에서만 되었었나? Arrays에서는 안되고
        //List<String> -> Stream<String> -> String[]
        // String[] answer = list.stream().filter(i->!i.equal("")).toArray();
        
        // 틀림 String[] answer = list.stream().filter(i->!i.equals("")).toArray(new String[0]);
        
        //그럼 String으로 중간에 한번 바꿔줘야하나?
        //list<String> -> Stream<String> -> String[]
        String[] answer = list.stream().filter(i->!i.equals(""))
                              .toArray(String[]::new);
        
        
        // Arrays.stream(String[]) 에서는 toArray()만 하면됨? 아니면 toArray(String::new)?
        
        if(answer.length == 0){
            //ArrayLiteral 생성하면서 초기화
            return new String[]{"EMPTY"};
        }
        return answer;

    }
}