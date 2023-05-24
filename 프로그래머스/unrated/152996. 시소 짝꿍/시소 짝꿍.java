import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int[] siso = {2, 3, 4};

        for (int weight : weights) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                int now = weight * siso[i];
                if (now % 2 == 0 && map.getOrDefault(now / 2, 0) != 0) {
                    set.add(now / 2);
                }
                if (now % 3 == 0 && map.getOrDefault(now / 3, 0) != 0) {
                    set.add(now / 3);
                }
                if (now % 4 == 0 && map.getOrDefault(now / 4, 0) != 0) {
                    set.add(now / 4);
                }
            }
            for (int w : set) {
                answer += map.get(w);
            }
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        return answer;
    }
}