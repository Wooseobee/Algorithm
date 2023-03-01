import java.util.*;

class Solution {

    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            drawMap(x1, y1, x2, y2);
        }

        return bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
    }

    static void drawMap(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                map[i][j] = 1;
            }
        }
    }

    static class Point {
        int i;
        int j;
        int cnt;

        public Point(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    static int bfs(int startI, int startJ, int endI, int endJ) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startI, startJ, 0));
        visited[startI][startJ] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.i == endI && p.j == endJ) return p.cnt / 2;

            for (int k = 0; k < 4; k++) {
                int i = p.i + di[k];
                int j = p.j + dj[k];
                int cnt = p.cnt + 1;

                if (i >= 0 && j >= 0 && i < 102 && j < 102 && !visited[i][j]) {
                    if (map[i][j] == 1) {
                        if (map[i][j - 1] == 0 || map[i][j + 1] == 0 || map[i - 1][j] == 0 | map[i + 1][j] == 0
                                || map[i - 1][j - 1] == 0 || map[i - 1][j + 1] == 0 || map[i + 1][j - 1] == 0 || map[i + 1][j + 1] == 0) {
                            q.add(new Point(i, j, cnt));
                            visited[i][j] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}