import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) list.add(findGroup(i, cards));
        }
        list.sort(Collections.reverseOrder());
        return list.size() == 1 ? 0 : list.get(0) * list.get(1);
    }

    private static int findGroup(int idx, int[] cards) {
        int cnt = 0;
        while (!visited[idx]) {
            visited[idx] = true;
            idx = cards[idx] - 1;
            cnt++;
        }
        return cnt;
    }
}