class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        for (int i = (int) begin, j = 0; i <= end; i++, j++) {
            if (i == 1) continue;

            int max = 0;
            for (int k = 2; k <= (int) Math.sqrt(i); k++) {
                if (i % k == 0) {
                    if (i / k <= 10_000_000) {
                        max = i / k;
                        answer[j] = i / k;
                        break;
                    } else {
                        max = k;
                    }
                }
            }
            if (max == 0) answer[j] = 1;
            else answer[j] = max;
        }
        return answer;
    }
}