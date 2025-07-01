class Solution {
    public int solution(int[][] sizes) {
        //최대값은 가로로 몰아 놓기
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<=sizes[i][1]){
                int temp = 0;
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        //가로길이 = max
        int width_max = 0;
        for(int i=0; i<sizes.length; i++){
            width_max = sizes[i][0] >= width_max ? sizes[i][0] : width_max;
        }
        
        //세로길이 = max
        int height_max = 0;
        for(int i=0; i<sizes.length; i++){
            height_max = sizes[i][1] >= height_max ? sizes[i][1] : height_max;
        }
        return width_max * height_max;
    }
}