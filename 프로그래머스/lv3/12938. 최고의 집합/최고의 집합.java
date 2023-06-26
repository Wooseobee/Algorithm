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
// 16 / 5 => 13 / 4 => 10 / 3 => 7 / 2 => 4 / 1
// 3 3 3 3 4