class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a && n >= 2) {
            int get = n / a * b;
            answer += get;
            n = n % a + get;
        }
        return answer;
    }
}