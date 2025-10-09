import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //today = "2022.05.19" // 2000~YYYY~2022 01~MM~12 01~DD~28
        //terms = ["A 6", "B 12", "C 3"] //달수는 1이상 ~ 100이하
        //privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]

        List<Integer> answer = new ArrayList<>();
        System.out.println(today);
        String[] str = today.split("\\.");
        // System.out.println(str[1]);
        
        String Today = str[0]+str[1]+str[2]; //20220519
        
        //약관입력
        Map<String,Integer> contracts = new HashMap<>();
        for(int i=0; i<terms.length; i++){
            String[] a = terms[i].split(" ");
            contracts.put(a[0],Integer.parseInt(a[1]));
        }
        
        //개인정보 유효기간 계산
        for(int i=0; i<privacies.length; i++){
            String[] x = privacies[i].split(" ");
            String type = x[1];
            String[] dates = x[0].split("\\.");
            int y = Integer.parseInt(dates[0]);//2021
            int m = Integer.parseInt(dates[1]); //05
            int d = Integer.parseInt(dates[2]);//14
            int plusMonths = contracts.get(type);
            //20191201 plusMonths=12 -> 20201127
            
            int totalMonths = (y*12 + (m-1)) + plusMonths;
            y = totalMonths/12;
            m = (totalMonths%12) +1;
            
            // if(m+plusMonths>12){
            //     y += (m+plusMonths)/12;
            //     m = (m+plusMonths)%12;
            // }else{
            //     m = m+plusMonths;
            // }
            
            if(d==1){
                d=28;
                if(m==1){
                    y--;
                    m=12;
                }else{
                    m--;
                }
            }else{
                d--;
            }
            //String Today = str[0]+str[1]+str[2]; //20220519
            String cal = String.valueOf(y)+(m>=10 ? String.valueOf(m) : "0"+m)+(d>=10 ? String.valueOf(d) : "0"+d);
            System.out.println("cal = " +cal);
            System.out.println("Today = " +Today);
            
            //cal = 20211101
            //Today-cal >0 유효기간지남.
            if(Today.compareTo(cal)>0)answer.add(i+1);
        }
        //List<Integer> -> Stream<Integer> ->IntSteram ->int[]
        return answer.stream().mapToInt(Integer::intValue).toArray();
        // return new int[]{-1};
    }
}