import java.util.*;

class Solution {
    static int[] candidate;
    static boolean[] visited;
    static int len, attributeLen;
    static int answer = 0;
    static List<List<Integer>> keyList = new ArrayList<>();

    public int solution(String[][] relation) {
        len = relation.length;
        attributeLen = relation[0].length;

        keyList.add(new ArrayList<>());

        for (int i = 1; i <= attributeLen; i++) {
            candidate = new int[i];
            visited = new boolean[attributeLen];
            dfs(0, 0, i, relation);
        }
        
        return answer;
    }

    static void dfs(int idx, int depth, int n, String[][] relation) {
        if (depth == n) {
            if (checkCandidate(relation)) answer++;
            return;
        }
        for (int i = idx; i < attributeLen; i++) {
            if (!visited[i]) {
                visited[i] = true;

                candidate[depth] = i;
                dfs(idx, depth + 1, n, relation);

                visited[i] = false;
            }
        }
    }

    static boolean checkCandidate(String[][] relation) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < answer; i++) {
            int cnt = 0;
            for (int idx : candidate) {
                if (keyList.get(i).contains(idx)) cnt++;
            }
            if (cnt == keyList.get(i).size()) return false;
        }

        for (int j = 0; j < len; j++) {
            String s = "";
            for (int idx : candidate) {
                s += relation[j][idx];
            }

            if (list.contains(s)) {
                return false;
            } else {
                list.add(s);
            }
        }

        keyList.add(new ArrayList<>());
        for (int idx : candidate) {
            keyList.get(answer).add(idx);
        }
        return true;
    }
}