import java.util.*;

class Solution {
    static Map<String, Integer> dict = new HashMap<>();
    static String[] alphabet = new String[]{"A", "E", "I", "O", "U"};
    static int num = 1;

    public int solution(String word) {
        int answer = 0;

        makeDictionary(new StringBuilder(), 0);

        answer = dict.get(word);
        return answer;
    }

    static void makeDictionary(StringBuilder sb, int depth) {
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            sb.append(alphabet[i]);
            if (!dict.containsKey(sb)) {
                dict.put(sb.toString(), num++);
            }
            makeDictionary(sb, depth + 1);
            sb.delete(depth, depth + 1);
        }
    }
}