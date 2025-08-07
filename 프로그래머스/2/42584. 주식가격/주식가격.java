class Solution {
    public int[] solution(int[] prices) {
        //[1,2,3,2,3]
        int[] answer = new int[prices.length];
        int count = 0;
        for(int i=0; i<prices.length-1; i++){
            count = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[i]<=prices[j]) {
                    count++;
                    // System.out.println("answer["+i+"] = "+ count);
                    answer[i] = count;
                                         }
                else {
                    count++;
                    answer[i] = count;
                    break;
                    // System.out.println("answer["+i+"] = "+ count);
                }
            }
            // System.out.println("answer["+i+"] = "+ count);
        }
        return answer;

    }
}