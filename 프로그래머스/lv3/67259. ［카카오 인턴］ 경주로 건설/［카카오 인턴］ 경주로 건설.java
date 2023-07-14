import java.util.*;

class Solution {
    class Point {
        int i;
        int j;
        int direction;
        int cnt;
        int corner;

        public Point(int i, int j, int direction, int cnt, int corner) {
            this.i = i;
            this.j = j;
            this.direction = direction;
            this.cnt = cnt;
            this.corner = corner;
        }
    }

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int size = board.length - 1;
        int[][][] dp = new int[4][size + 1][size + 1];

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                for (int k = 0; k < 4; k++) {
                    if (board[i][j] == 1)
                        dp[k][i][j] = 1;
                    else
                        dp[k][i][j] = answer;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            dp[i][0][0] = 0;
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, -1, 0, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int i = p.i;
            int j = p.j;
            int dir = p.direction;
            int cnt = p.cnt;
            int corner = p.corner;
            int cost = cnt * 100 + corner * 500;
            if (i == size && j == size) {
                answer = Math.min(answer, cost);
            }
            for (int k = 0; k < 4; k++) {
                int newI = i + dx[k];
                int newJ = j + dy[k];
                if (newI >= 0 && newJ >= 0 && newI <= size && newJ <= size && dp[k][newI][newJ] != 1) {
                    if (dir == -1) {
                        q.add(new Point(newI, newJ, k, 1, 0));
                        dp[k][newI][newJ] = 100;
                    } else if (dir == k && dp[k][newI][newJ] >= cost + 100) {
                        q.add(new Point(newI, newJ, k, cnt + 1, corner));
                        dp[k][newI][newJ] = cost + 100;
                    } else {
                        if (dp[k][newI][newJ] >= cost + 500) {
                            q.add(new Point(newI, newJ, k, cnt + 1, corner + 1));
                            dp[k][newI][newJ] = cost + 500;
                        }
                    }
                }
            }
        }

        return answer;
    }
}