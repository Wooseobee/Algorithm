import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : X.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<String> answer = new ArrayList<>();
        for (char ch : Y.toCharArray()) {
            if (map.containsKey(ch) && map.get(ch) > 0) {
                answer.add(String.valueOf(ch));
                map.put(ch, map.get(ch) - 1);
            }
        }
        answer.sort(Collections.reverseOrder());
        String ans = new StringBuilder().append(answer.toString().replaceAll("[^0-9]", "")).toString();
        return ans.isEmpty() ? "-1" : ans.charAt(0) == '0' ? "0" : ans;
    }
}