import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = new int[7]; //0..6  0-based
        arr[a]++; arr[b]++; arr[c]++; arr[d]++;
        int kind = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0)kind++;
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        map.merge(a,1,(old,add)->old+add);
        map.compute(b,(k,v)->(v==null)? 1: v+1);
        map.compute(c,(k,v)->(v==null)? 1: v+1);
        map.compute(d,(k,v)->(v==null)? 1: v+1);
    
        int p=0, q=0;
        
        boolean three = false;
        if(kind==2){
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                if(e.getValue()>2){
                    three = true;
                    p = e.getKey();
                } 
            }
        }
        if(kind==2 && !three){
            int[] arr2 = {a,b,c,d};
            Set<Integer> set = new HashSet<>();
            for(int n : arr2) set.add(n);
            List<Integer> list = new ArrayList<>(set);
            p = list.get(0); q = list.get(1);
        }
      
        
        
  
        switch(kind){
            case 1:{
                return 1111*a;
                // System.out.println(1111*map.get(a));
                // break;
            }
            case 2:{
                if(three){
                    for(Map.Entry<Integer,Integer> e : map.entrySet()){
                    if(e.getValue() == 1) q = e.getKey();
                    // System.out.println(Math.pow( (10*p+q),2););
                    }
                    return (int)Math.pow( (10*p+q),2);
                }else{
                    // System.out.println(Math.abs(p-q));
                    return (p+q)*Math.abs(p-q);
                }
                // break;
            }
            case 3:{
                int result = 1;
                for(Map.Entry<Integer,Integer> e : map.entrySet()){
                    if(e.getValue() == 2) continue;
                    result*=e.getKey();
                }
                return result;
                // break;
            }
            case 4:{
                int min = Integer.MAX_VALUE;
                for(Map.Entry<Integer,Integer>e : map.entrySet()){
                    min = Math.min(min, e.getKey());
                }
                // System.out.println(min);
                return min;
                // break;
            }
            default: 
                // System.out.println("no match");
                return 0;
        }

    }
}