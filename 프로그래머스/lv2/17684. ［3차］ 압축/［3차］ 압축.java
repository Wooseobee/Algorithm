import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int len = msg.length();
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        char ch = 'A';
        for (int i = 1; i <= 26; i++) {
            dict.put(String.valueOf(ch), i);
            ch++;
        }
        int idx = 27;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            boolean removeLast = true;
            while (dict.containsKey(sb.toString())) {
                i++;
                if (i == len) {
                    removeLast = false;
                    break;
                }
                sb.append(msg.charAt(i));
            }
            i--;
            if (removeLast) {
                dict.put(sb.toString(), idx++);
                sb.deleteCharAt(sb.length() - 1);
            }
            String s = sb.toString();
            answer.add(dict.get(s));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}