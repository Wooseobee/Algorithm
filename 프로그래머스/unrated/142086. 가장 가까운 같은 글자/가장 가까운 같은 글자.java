import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            answer[i] = map.getOrDefault(s.charAt(i), -1);
            if (answer[i] != -1) answer[i] = i - answer[i];
            map.put(s.charAt(i), i);
        }
        return answer;
    }
}