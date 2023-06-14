class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;

        for (int i = 2; i <= number; i++) {
            int cnt = count(i);
            if (cnt > limit) answer += power;
            else answer += cnt;
        }

        return answer;
    }

    public int count(int n) {
        int cnt = 0;
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) cnt += 2;
        }
        return cnt + ((int) Math.sqrt(n) * Math.sqrt(n) == n ? 1 : 0);
    }
}