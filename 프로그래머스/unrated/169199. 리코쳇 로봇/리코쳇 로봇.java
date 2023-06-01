import java.util.*;

class Solution {
    class Point {
        int i;
        int j;
        int moveCnt;

        public Point(int i, int j, int moveCnt) {
            this.i = i;
            this.j = j;
            this.moveCnt = moveCnt;
        }
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] board) {
        int[] coords = findRobot(board);
        int answer = bfs(coords[0], coords[1], board);
        return answer;
    }

    private int bfs(int startI, int startJ, String[] board) {
        Queue<Point> q = new LinkedList<>();
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];
        q.add(new Point(startI, startJ, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();
            int i = now.i;
            int j = now.j;

            if (board[i].charAt(j) == 'G') return now.moveCnt;

            for (int k = 0; k < 4; k++) {
                int newI = i + dy[k];
                int newJ = j + dx[k];
                if (!(newI >= 0 && newJ >= 0 && newI < n && newJ < m)) continue;
                while (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (board[newI].charAt(newJ) == 'D') break;
                    newI += dy[k];
                    newJ += dx[k];
                }
                if (!visited[newI - dy[k]][newJ - dx[k]]) {
                    q.add(new Point(newI - dy[k], newJ - dx[k], now.moveCnt + 1));
                    visited[newI - dy[k]][newJ - dx[k]] = true;
                }
            }
        }
        return -1;
    }

    private int[] findRobot(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }
}