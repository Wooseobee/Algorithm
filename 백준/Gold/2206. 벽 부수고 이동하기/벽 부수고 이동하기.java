import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(bfs());

        br.close();
    }

    static class Point {
        int i;
        int j;
        int cnt;
        boolean breakWall;

        public Point(int i, int j, int cnt, boolean breakWall) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.breakWall = breakWall;
        }
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][] breakVisited = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];

        q.add(new Point(0, 0, 1, false));
        visited[0][0] = true;
        breakVisited[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.i == n - 1 && p.j == m - 1) {
                return p.cnt;
            }

            for (int k = 0; k < 4; k++) {
                int i = p.i + dy[k];
                int j = p.j + dx[k];
                int cnt = p.cnt + 1;
                boolean breakWall = p.breakWall;
                if (i >= 0 && j >= 0 && i < n && j < m) {
                    if (breakWall) {
                        if (map[i][j] == 0 && !breakVisited[i][j]) {
                            q.add(new Point(i, j, cnt, true));
                            breakVisited[i][j] = true;
                        }
                    } else {
                        if (map[i][j] == 0 && !visited[i][j]) {
                            q.add(new Point(i, j, cnt, false));
                            visited[i][j] = true;
                        } else if (map[i][j] == 1 && !breakVisited[i][j]) {
                            q.add(new Point(i, j, cnt, true));
                            breakVisited[i][j] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}