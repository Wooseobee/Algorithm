class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int total = 0;
        for(int i=0;i<3;i++){
            if(sides[i] > max) {
                max = sides[i];
            }
            total += sides[i];
        }
        total-=max;
        return total > max ? 1 : 2;
    }
}