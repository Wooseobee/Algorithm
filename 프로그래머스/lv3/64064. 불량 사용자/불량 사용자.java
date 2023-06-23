import java.util.*;

class Solution {
    List<Integer>[] candidate;
    Set<String> answerList = new HashSet<>();
    boolean[] used;

    public int solution(String[] user_id, String[] banned_id) {
        int len = banned_id.length;
        candidate = new List[len];
        used = new boolean[user_id.length];
        for (int i = 0; i < len; i++) candidate[i] = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String ban = banned_id[i];
            for (int j = 0; j < user_id.length; j++) {
                if (ban.length() == user_id[j].length() && matching(ban, user_id[j])) {
                    candidate[i].add(j);
                }
            }
        }
        checkCandidate(0, len, 0);
        return answerList.size();
    }

    public void checkCandidate(int depth, int len, int idx) {
        if (depth == len) {
            String s = "";
            for (int i = 0; i < used.length; i++) {
                if (used[i]) s += i;
            }
            if (answerList.contains(s)) return;
            answerList.add(s);
            return;
        }
        for (int i = 0; i < candidate[depth].size(); i++) {
            int index = candidate[depth].get(i);
            if (!used[index]) {
                used[index] = true;

                checkCandidate(depth + 1, len, idx + 1);

                used[index] = false;
            }
        }
    }

    public boolean matching(String ban, String user) {
        int len = ban.length();
        for (int i = 0; i < len; i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}