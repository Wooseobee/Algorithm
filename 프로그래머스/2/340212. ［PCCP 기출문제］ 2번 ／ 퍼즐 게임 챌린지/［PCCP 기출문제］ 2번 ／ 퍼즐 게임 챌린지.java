class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 이분탐색
        int l = 1;
        int r = 100_000;
        while(l < r) {
            int level = (l + r) / 2;
            long time_total = 0;
            long time_prev = 0;
            for(int i = 0; i < diffs.length; i++) {
                int time_cur = times[i];
                int diff = diffs[i];
                if(diff <= level) {
                    time_total += time_cur;
                    time_prev = time_cur;
                } else {
                    long usingTime = (diff - level) * (times[i - 1] + time_cur) + time_cur;
                    time_total += usingTime;
                    time_prev = usingTime;
                }
                if(time_total > limit) {
                    l = level + 1;
                    break;
                }
            }
            
            if(time_total <= limit) {
                r = level;
            }
        }
        return l;
    }
}