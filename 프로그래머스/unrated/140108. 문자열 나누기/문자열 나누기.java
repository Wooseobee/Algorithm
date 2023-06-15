class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 1;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                answer++;
                if (i != s.length() - 1) ch = s.charAt(i + 1);
            }
        }
        return cnt != 0 ? answer + 1 : answer;
    }
}