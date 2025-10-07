import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Solution {
    public int[] solution(int[] fees, String[] records) {
    
    //자동차번호 -> 입/출차 시간기록(분)
    Map<Integer,List<Integer>> carTimeList = new HashMap<>();
    //자동차번호 -> 주차 요금
    Map<Integer,Integer> carFeeList = new HashMap<>();
    //자동차 리스트
    Set<Integer> carList = new HashSet<>();
    
	  for(int i=0; i<records.length;i++){
		  String[] strs = records[i].split(" ");
		  int carNumber = Integer.parseInt(strs[1]);
		  
		  //자동차 리스트에 추가
		  carList.add(carNumber);
		  //입/출차 시간기록(분)
		  int h = Integer.parseInt(strs[0].substring(0,2));
		  int m = Integer.parseInt(strs[0].substring(3));
		  int time = h*60 + m;
		  carTimeList.computeIfAbsent(carNumber, k-> (new ArrayList<Integer>())).add(time);
	  }
	  
	  //차랑별 소요 시간-> 요금
	  for(Map.Entry<Integer,List<Integer>> e : carTimeList.entrySet()){
		  int carNumber = e.getKey();
		  List<Integer> cur = e.getValue();
          int total = 0;
		  
		//입/출차 시간기록이 홀수개면 마지막에 23:59 추가
		if(cur.size()%2 !=0){
		    cur.add(23*60+59);
	    }
	    //두 개씩 계산(출차시간-입차시간)
	    int[] cals = new int[2];
	    for(int k=0; k<cur.size(); k++){
		    cals[k%2] = cur.get(k);
		    if(k%2!=0){
			    total += cals[1]-cals[0];
		    }
	    }
        if(total<=fees[0]){
            carFeeList.put(carNumber,fees[1]);
        }else{
            int f = total - fees[0];
            carFeeList.put(carNumber, fees[1]+(int)Math.ceil((double)f/fees[2])*fees[3]);
        }
	  }
    
	//차량별 요금 출력
	List<Integer> carLists = new ArrayList<>(carList);
    Collections.sort(carLists);
    
    //StreamAPI 이용해서 int[]반환
    //List<Integer> -> Stream<Integer> -> Stream<Integer> -> IntStream -> int[]
    return carLists.stream().map(i->carFeeList.get(i)).mapToInt(Integer::intValue).toArray();

    }
}