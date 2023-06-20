class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int mod = w * 2 + 1;
        int start = 1;
        for (int s : stations) {
            int end = s - w - 1;
            if (start > end) {
                start = s + w + 1;
                continue;
            }
            if (end < 1) {
                start = s + w + 1;
                continue;
            }
            int diff = end - start + 1;
            if (diff % mod == 0) answer += diff / mod;
            else answer += diff / mod + 1;
            start = s + w + 1;
        }
        if (start < n + 1) {
            int diff = n - start + 1;
            if (diff % mod == 0) answer += diff / mod;
            else answer += diff / mod + 1;
        }

        return answer;
    }
}