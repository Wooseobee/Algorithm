import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = number.length;

        for (int i = 0; i < discount.length - len; i++) {
            Map<String, Integer> discountProduct = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                if (i + j == discount.length) break;
                String todayFood = discount[i + j];
                discountProduct.put(todayFood, discountProduct.getOrDefault(todayFood, 0) + 1);
            }
            if (canRegist(want, number, discountProduct)) answer++;
        }
        return answer;
    }

    private static boolean canRegist(String[] want, int[] number, Map<String, Integer> discountProduct) {
        for (int i = 0; i < want.length; i++) {
            String product = want[i];
            if (!discountProduct.containsKey(product) || discountProduct.get(product) < number[i]) return false;
        }
        return true;
    }
}