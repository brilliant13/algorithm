class Solution {
    public int solution(String[] order) {
        //메뉴만 -> 차가운 것
        //아무거나 -> 차가운 아메리카노
        int sum = 0;
        for(int i=0; i<order.length; i++){
            if(order[i].contains("americano")||order[i].equals("anything")){
                sum += 4500;
            }else{
                sum +=5000;
            }
        }
        return sum;
    }
}