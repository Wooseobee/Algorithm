import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, min = Integer.MAX_VALUE, islandNum = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, islandNum++);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    if (i + moveY[k] >= 0 && j + moveX[k] >= 0 && i + moveY[k] < n && j + moveX[k] < n && map[i + moveY[k]][j + moveX[k]] == 0) {
                        cnt++;
                    }
                }
                if (cnt > 0 && map[i][j] != 0) {
                    findIsland(i, j, map[i][j]);
                }
            }
        }
        System.out.println(min);
        br.close();
    }

    static class PointWithCount {
        int i;
        int j;
        int count;

        public PointWithCount(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    static void findIsland(int i, int j, int islandNum) {
        Queue<PointWithCount> q = new LinkedList<>();
        q.add(new PointWithCount(i, j, 0));
        visited[i][j] = true;

        for (int k = 0; k < n; k++) {
            Arrays.fill(visited[k], false);
        }

        while (!q.isEmpty()) {
            PointWithCount newP = q.poll();
            int newI = newP.i;
            int newJ = newP.j;
            int newCount = newP.count;

            for (int k = 0; k < 4; k++) {
                if (newI + moveY[k] >= 0 && newJ + moveX[k] >= 0 && newI + moveY[k] < n && newJ + moveX[k] < n && !visited[newI + moveY[k]][newJ + moveX[k]]) {
                    if (!visited[newI + moveY[k]][newJ + moveX[k]] && map[newI + moveY[k]][newJ + moveX[k]] == 0) {
                        q.add(new PointWithCount(newI + moveY[k], newJ + moveX[k], newCount + 1));
                        visited[newI + moveY[k]][newJ + moveX[k]] = true;
                    } else if (map[newI + moveY[k]][newJ + moveX[k]] != islandNum) {
                        min = Math.min(min, newCount);
                        return;
                    }
                }
            }
        }
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void bfs(int i, int j, int islandNum) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point newP = q.poll();
            int newI = newP.i;
            int newJ = newP.j;
            map[newI][newJ] = islandNum;

            for (int k = 0; k < 4; k++) {
                if (newI + moveY[k] >= 0 && newJ + moveX[k] >= 0 && newI + moveY[k] < n && newJ + moveX[k] < n) {
                    if (!visited[newI + moveY[k]][newJ + moveX[k]] && map[newI + moveY[k]][newJ + moveX[k]] == 1) {
                        q.add(new Point(newI + moveY[k], newJ + moveX[k]));
                        visited[newI + moveY[k]][newJ + moveX[k]] = true;
                    }
                }
            }
        }
    }
}