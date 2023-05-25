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
                first = firstGroup(i, cards);
                if (!visited[j]) second = secondGroup(j, cards);
                answer = Math.max(answer, first * second);
            }
        }
        return answer;
    }

    private static int firstGroup(int idx, int[] cards) {
        Arrays.fill(visited, false);
        int cnt = 0;
        while (!visited[idx]) {
            visited[idx] = true;
            idx = cards[idx] - 1;
            cnt++;
        }
        return cnt;
    }

    private static int secondGroup(int idx, int[] cards) {
        int cnt = 0;
        while (!visited[idx]) {
            visited[idx] = true;
            idx = cards[idx] - 1;
            cnt++;
        }
        return cnt;
    }
}