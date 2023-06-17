import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> lankMap = new HashMap<>();
        int order = 0;
        for (String p : players) {
            map.put(p, order);
            lankMap.put(order++, p);
        }
        for (String p1 : callings) {
            int lank = map.get(p1);
            String p2 = lankMap.get(lank - 1);
            map.put(p1, lank - 1);
            map.put(p2, lank);
            lankMap.put(lank - 1, p1);
            lankMap.put(lank, p2);
        }
        for (int i = 0; i < players.length; i++) {
            answer[i] = lankMap.get(i);
        }
        return answer;
    }
}