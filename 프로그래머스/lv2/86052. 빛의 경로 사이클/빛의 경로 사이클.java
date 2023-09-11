import java.util.*;

class Solution {
    int n;
    int m;
    // 상 하 우 좌
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    List<Integer> list = new ArrayList<>();
    boolean[][][] visited;

    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                start(grid, i, j);
            }
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private void start(String[] grid, int i, int j) {
        for (int k = 0; k < 4; k++) {
            if (!visited[i][j][k]) {
                isCycle(grid, i, j, k);
            }
        }
    }

    private void isCycle(String[] grid, int si, int sj, int sDir) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj, 0, sDir});  // i, j, dist, direction
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int dist = now[2];
            int direction = now[3];
            if (visited[i][j][direction]) {
                list.add(dist);
                return;
            }
            visited[i][j][direction] = true;

            char nowCh = grid[i].charAt(j);
            int nI, nJ;
            switch (nowCh) {
                case 'S':
                    nI = i + dx[direction];
                    nJ = j + dy[direction];
                    q.add(new int[]{nI < 0 ? n - 1 : nI % n, nJ < 0 ? m - 1 : nJ % m, dist + 1, direction});
                    break;
                case 'L':
                    nI = i + dx[(direction + 1) % 4];
                    nJ = j + dy[(direction + 1) % 4];
                    q.add(new int[]{nI < 0 ? n - 1 : nI % n, nJ < 0 ? m - 1 : nJ % m, dist + 1, (direction + 1) % 4});
                    break;
                case 'R':
                    nI = i + dx[(direction + 3) % 4];
                    nJ = j + dy[(direction + 3) % 4];
                    q.add(new int[]{nI < 0 ? n - 1 : nI % n, nJ < 0 ? m - 1 : nJ % m, dist + 1, (direction + 3) % 4});
                    break;
                default:
                    break;
            }
        }
    }
}