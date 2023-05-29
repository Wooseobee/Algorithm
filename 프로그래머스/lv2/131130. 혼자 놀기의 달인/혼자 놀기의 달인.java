import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int first = 0;
                int second = 0;
                Arrays.fill(visited, false);
                first = findGroup(i, cards);
                if (!visited[j]) second = findGroup(j, cards);
                answer = Math.max(answer, first * second);
            }
        }
        return answer;
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