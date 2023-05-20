import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int len = topping.length;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            set2.add(i);
        }
        for (int i = 0; i < len - 1; i++) {
            int nowTopping = topping[i];
            set1.add(nowTopping);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) {
                set2.remove(nowTopping);
            }
            if (set1.size() == set2.size()) answer++;
        }
        return answer;
    }
}