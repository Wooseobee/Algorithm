import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int cnt = 0;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        list = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < n - 1; i++) {
            cnt = 0;
            dfs(wires[i][0], wires[i][1]);
            answer = Math.min(answer, Math.abs((n - (cnt + 1)) - (cnt + 1)));
            Arrays.fill(visited, false);
        }

        return answer;
    }

    static void dfs(int idx, int j) {
        if (!visited[idx]) {
            visited[idx] = true;
            for (int i = 0; i < list[idx].size(); i++) {
                int next = list[idx].get(i);
                if (!visited[next] && next != j) {
                    cnt++;
                    dfs(next, j);
                }
            }
        }
    }
}