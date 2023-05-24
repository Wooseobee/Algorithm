class Solution {
    public static long solution(int w, int h) {
        long answer = 0;
        for (long i = 1; i < w; i++) {
            long height = (long) h * i / w;
            answer += height;
        }
        return answer * 2;
    }
}