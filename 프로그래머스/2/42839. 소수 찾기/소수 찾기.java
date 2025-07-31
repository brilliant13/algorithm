import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primes = new HashSet<>();
        char[] nums = numbers.toCharArray();
        boolean[] used = new boolean[nums.length];
        
        //모든 가능한 순열을 생성 -> 소수찾기
        generateNumbers(nums, used, "", primes);
        return primes.size();

    }
    
    private void generateNumbers(char[] nums, boolean[] used, String current, Set<Integer> primes){
        if(!current.isEmpty()){
            int num = Integer.parseInt(current);
            if (isPrime(num)){
                primes.add(num);
            }
        }
        
        for(int i =0; i<nums.length;i++){
            if(!used[i]){
                used[i] = true;
                generateNumbers(nums,used,current+nums[i],primes);
                used[i] = false;
            }
        }
    }
    public boolean isPrime(int n){
        if(n<2) return false;
        int limit = (int)Math.sqrt(n);
        for(int d =2; d<= limit; d++){
            if(n%d == 0) return false;
        }
        return true;
    }
}