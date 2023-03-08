import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 0, right = distance, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;   // 돌 다리 사이의 거리
            int removed = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    removed++;
                } else {
                    prev = rocks[i];
                }
            }
            if (distance - rocks[rocks.length - 1] < mid) {
                removed++;
            }
            if (removed <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1;
    }
}