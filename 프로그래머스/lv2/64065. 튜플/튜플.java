import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] strings = s.replaceAll("^[{]{2}|[}]{2}$", "").split("[}]{1}[,]{1}[{]{1}");

        Map<Integer, Integer> elements = new HashMap<>();

        for (String str : strings) {
            String[] strs = str.split(",");
            for (String element : strs) {
                elements.put(Integer.parseInt(element), elements.getOrDefault(Integer.parseInt(element), 0) + 1);
            }
        }

        int size = elements.size();
        int[] ans = new int[size];

        for (int key : elements.keySet()) {
            ans[size - elements.get(key)] = key;
        }

        return ans;
    }
}