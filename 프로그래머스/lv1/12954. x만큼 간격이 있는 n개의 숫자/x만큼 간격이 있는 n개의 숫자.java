class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int j = 0; j < n; j++) {
            answer[j] = (long) x * (j + 1);
        }
        return answer;
    }
}