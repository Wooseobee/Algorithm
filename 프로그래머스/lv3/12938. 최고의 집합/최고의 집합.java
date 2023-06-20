class Solution {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};
        int[] answer = new int[n];
        int i = 0;
        while(n > 0) {
            answer[i++] = s / n;
            s -= answer[i-1];
            n--;
        }
        return answer;
    }
}