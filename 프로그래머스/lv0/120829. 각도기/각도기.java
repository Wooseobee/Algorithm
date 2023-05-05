class Solution {
    public int solution(int angle) {
        if(angle<=90) return angle == 90 ? 2 : 1;
        return angle == 180 ? 4 : 3;
    }
}