class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while (n > 0) {
            int div = n % 3;
            n /= 3;
            if (div == 0) {
                answer.insert(0, "4");
                n -= 1;
            }else {
                answer.insert(0, div);
            }
        }
        return answer.toString();
    }
}