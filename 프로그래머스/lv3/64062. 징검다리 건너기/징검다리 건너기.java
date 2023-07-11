class Solution {
    public int solution(int[] stones, int k) {
        int min = 0;
        int max = Integer.MAX_VALUE;
        int answer = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (canCross(mid, k, stones)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int mid, int k, int[] stones) {
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid) {
                cnt++;
                if (cnt >= k) return false;
            } else cnt = 0;
        }
        return true;
    }
}