class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (countDivisor(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public int countDivisor(int i) {
        int cnt = 0;
        for (int j = 1; j < Math.sqrt(i); j++) {
            if (i % j == 0) cnt++;
        }
        return cnt * 2 + (i % Math.sqrt(i) == 0 ? 1 : 0);
    }
}