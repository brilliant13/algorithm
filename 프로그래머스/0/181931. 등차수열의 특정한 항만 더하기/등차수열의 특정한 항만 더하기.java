class Solution {
    public int solution(int a, int d, boolean[] included) {
        //정수 a, b  길이가 n인 boolean배열 included
        //첫째항 a, 공차d
        //included[i]가 i+1항을 의미 included[0]이 1항을의미
        //1항4항5항 3*a + 7*d = 9 + 28 = 37
        int sum = 0;
        for(int i=0; i<included.length; i++){
            if(included[i]){
                //i+1항
                sum += (a+d*i);
            }
        }
        return sum;
    }
}