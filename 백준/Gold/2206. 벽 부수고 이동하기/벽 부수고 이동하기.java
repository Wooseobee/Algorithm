import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

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
        int count;
        boolean breakWall;

        public Point(int i, int j, int count, boolean breakWall) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.breakWall = breakWall;
        }
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, false));
        boolean[][] unBreakVisited = new boolean[n][m];
        boolean[][] BreakVisited = new boolean[n][m];
        unBreakVisited[0][0] = true;

        while (!q.isEmpty()) {
            Point newPoint = q.poll();
            int i = newPoint.i;
            int j = newPoint.j;
            int count = newPoint.count;
            boolean breakWall = newPoint.breakWall;

            if (i == n - 1 && j == m - 1) {
                return count;
            }

            for (int k = 0; k < 4; k++) {
                int newI = i + moveY[k];
                int newJ = j + moveX[k];
                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (breakWall) {
                        if (map[newI][newJ] == 0 && ! BreakVisited[newI][newJ]) {
                            q.add(new Point(newI, newJ, count + 1, true));
                            BreakVisited[newI][newJ] = true;
                        }
                    } else {
                        if (map[newI][newJ] == 0 && !unBreakVisited[newI][newJ]) {
                            q.add(new Point(newI, newJ, count + 1, false));
                            unBreakVisited[newI][newJ] = true;
                        } else if (map[newI][newJ] == 1 && !BreakVisited[newI][newJ]){
                            q.add(new Point(newI, newJ, count + 1, true));
                            BreakVisited[newI][newJ] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}