import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        //정수배열 arr이 매개변수
        // 2^0=1 ~ 2^9=512까지
        // 답은 1000넘어도되니까, arr이 512보다 큰 경우를 대비하기 위해서 1024승도 넣어두자.
        // 문제가 거듭제곱개수를 맞추기 위해 0을 제거하는게 아니라 0을 추가하는 거니까.
        
        int [] dp = new int [11]; //0~10
        
        for(int i=0; i<11; i++){
            dp[i]=(int)Math.pow(2,i);
        }
        
        int size = arr.length;
        int pow = 0;
        for(int i=0; i<11; i++){
            if(dp[i]>=size){
                pow = i;
                break;
            }
        }
        return Arrays.copyOf(arr,(int)Math.pow(2,pow));
    }
}