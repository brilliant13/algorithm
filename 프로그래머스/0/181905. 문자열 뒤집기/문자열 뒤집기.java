class Solution {
    public String solution(String my_string, int s, int e) {
        //문자열 my_string, 정수 s,e   [s,e]
        String target = my_string.substring(s,e+1);
        //String[] -> String
        //String.join("",String[]);
        String[] arr = target.split(""); //하나하나씩 문자열 배열로 변환
        //거꾸로 넣기 [e,s]
        String reversed="";
        for(int i=arr.length-1; i>=0; i--){
            reversed += arr[i];
        }
        return my_string.replace(target,reversed);
        //바꿔야하는부분 찾아서 replace(바꿀부분,역으로 뒤집은것)
        
        
    }
}