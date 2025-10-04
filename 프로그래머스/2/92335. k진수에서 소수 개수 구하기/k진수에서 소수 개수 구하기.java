import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int k) {
        String sequence = changeNumeralSystem(n,k);
        System.out.println(sequence);

        StringTokenizer st = new StringTokenizer(sequence,"0");
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        int count = 0;
        for(int i=0; i<list.size(); i++){
            if(isPrime(Long.parseLong(list.get(i))))count++;
        }
        return count;
    }
    //isPrime()
    public boolean isPrime(long num){
        if(num<2) return false;
        if(num==2) return true;
        if(num%2==0) return false; //짝수는 소수 아님. 2*x
        
        long limit = (long)Math.sqrt(num);
        for(long i=3; i<=limit; i+=2){ //홀수만 체크
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    
    //changeNumeralSystem()
    public String changeNumeralSystem(int n, int k){
        //나누고, 몫을 저장해 나간다. 몫이 k보다 작아서 더 이상 나눌 수 없을 때, 그 몫을 마지막 리스트원소로 넣는다.
        LinkedList<Integer> seq = new LinkedList<>(); //List,Queue,Deque처럼 사용가능
        int quotient = n;
        //몫 줄여가며 나머지 앞에 쌓기
        while(quotient>=k){
            seq.addFirst(quotient%k);
            quotient/=k;
        }
        seq.addFirst(quotient); //마지막 몫
        
        //211020101011 
        StringBuilder sb = new StringBuilder();
        while(!seq.isEmpty()){
            sb.append(seq.pollFirst());
        }
        return sb.toString();
    }
}