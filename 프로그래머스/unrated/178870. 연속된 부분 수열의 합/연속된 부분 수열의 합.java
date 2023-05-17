import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLen = Integer.MAX_VALUE;
        int len = sequence.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start < len && end <= len) {
            if (sum >= k) {
                if (sum == k && minLen > end - start + 1) {
                    minLen = end - start + 1;
                    answer[0] = start;
                    answer[1] = end - 1;
                }
                sum -= sequence[start++];
            } else {
                if (end >= len) break;
                sum += sequence[end++];
            }
        }
        return answer;
    }
}