import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> list = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!list.containsKey(nums[i])) {
                list.put(nums[i], 1);
            } else {
                list.put(nums[i], list.get(nums[i]) + 1);
            }
        }

        answer = nums.length / 2;
        if (list.size() < nums.length / 2) {
            answer = list.size();
        }

        return answer;
    }
}