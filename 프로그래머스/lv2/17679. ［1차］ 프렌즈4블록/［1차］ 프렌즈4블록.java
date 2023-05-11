import java.util.*;

class Solution {
    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return this.i == p.i && this.j == p.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static char[][] arr;
    static boolean[][] visited;
    static Set<Point> removeList = new HashSet<>();

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][n];
        visited = new boolean[m][n];
        boolean canRemove = false;

        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }

        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != '*' && !visited[i][j]) {
                        bfs(i, j, m, n);
                    }
                }
            }
            int cnt = removeAll();
            if (cnt == 0) break;    // 삭제된 블록이 없으면 게임 종료
            answer += cnt;
            resetData(m);
            moveRemainBlock(m, n);
        }

        return answer;
    }

    private static void moveRemainBlock(int m, int n) {     // 남아있는 블록 내리기
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (arr[i][j] != '*') {
                    for (int k = m - 1; k > i; k--) {
                        if (arr[k][j] == '*') {
                            arr[k][j] = arr[i][j];
                            arr[i][j] = '*';
                        }
                    }
                }
            }
        }
    }

    private static void resetData(int m) {  // removeList, visited 초기화
        removeList.clear();
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private static int removeAll() {    // removeList 삭제
        int cnt = 0;
        for (Point p : removeList) {
            arr[p.i][p.j] = '*';
            cnt++;
        }
        return cnt;
    }

    private static void bfs(int i, int j, int m, int n) {   // 삭제가능한 블록 모두 removeList에 담기
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));

        while (!q.isEmpty()) {
            Point p = q.poll();
            int cnt = 0;
            char now = arr[p.i][p.j];
            for (int k = 0; k < 3; k++) {
                int newI = p.i + dy[k];
                int newJ = p.j + dx[k];
                if (newI < m && newJ < n && now == arr[newI][newJ]) cnt++;
            }
            if (cnt == 3) {
                removeList.add(new Point(i, j));
                for (int k = 0; k < 3; k++) {
                    int newI = p.i + dy[k];
                    int newJ = p.j + dx[k];
                    if (!visited[newI][newJ]) {
                        q.add(new Point(newI, newJ));
                        removeList.add(new Point(newI, newJ));
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
    }
}