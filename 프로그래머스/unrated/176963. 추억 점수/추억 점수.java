import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int len = photo.length;
        int[] answer = new int[len];
        Map<String, Integer> score = new HashMap<>();

        for (int i = 0; i < yearning.length; i++) {
            score.put(name[i], yearning[i]);
        }

        for (int i = 0; i < len; i++) {
            int total = 0;
            for (int j = 0; j < photo[i].length; j++) {
                total += score.getOrDefault(photo[i][j], 0);
            }
            answer[i] = total;
        }

        return answer;
    }
}