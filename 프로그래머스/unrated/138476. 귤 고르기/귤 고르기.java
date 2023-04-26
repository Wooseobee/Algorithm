import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> sizeMap = new HashMap<>();

        for (int tan : tangerine) {
            sizeMap.put(tan, sizeMap.getOrDefault(tan, 0) + 1);
        }

        List<Integer> value = new ArrayList<>(sizeMap.values());

        value.sort(Collections.reverseOrder());

        while (k > 0) {
            k -= value.get(answer++);
        }

        return answer;
    }
}