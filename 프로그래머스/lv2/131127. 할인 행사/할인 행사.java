import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = number.length;
        Map<String, Integer> product = new HashMap<>();

        for (int i = 0; i < discount.length - len; i++) {
            for (int j = 0; j < len; j++) {
                product.put(want[j], number[j]);
            }
            for (int j = 0; j < 10; j++) {
                if (i + j == discount.length) break;
                String todayFood = discount[i + j];
                if (product.containsKey(todayFood)) {
                    product.put(todayFood, product.get(todayFood) - 1);
                }
            }
            boolean canRegist = true;
            for (int value : product.values()) {
                if (value != 0) {
                    canRegist = false;
                    break;
                }
            }
            if (canRegist) answer++;
        }
        return answer;
    }
}