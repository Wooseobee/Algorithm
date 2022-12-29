import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> list = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            if (!list.containsKey(participant[i])) {
                list.put(participant[i], 1);
            } else {
                list.put(participant[i], list.get(participant[i]) + 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (list.get(completion[i]) == 1) {
                list.remove(completion[i]);
            } else {
                list.put(completion[i], list.get(completion[i]) - 1);
            }
        }
        

        for (String Key : list.keySet()) {
            answer = Key;
        }

        return answer;
    }
}