import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] factory;
    static boolean[][] visited;
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        factory = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                factory[i][j] = Integer.parseInt(input[j]);
            }
        }
        input = br.readLine().split(" ");
        int startI = Integer.parseInt(input[0]) - 1;
        int startJ = Integer.parseInt(input[1]) - 1;
        int startD = Integer.parseInt(input[2]) - 1;

        input = br.readLine().split(" ");
        int endI = Integer.parseInt(input[0]) - 1;
        int endJ = Integer.parseInt(input[1]) - 1;
        int endD = Integer.parseInt(input[2]) - 1;

        System.out.println(bfs(startI, startJ, startD, endI, endJ, endD));
        br.close();
    }

    static class Point {
        int i;
        int j;
        int dir;
        int order;

        public Point(int i, int j, int dir, int order) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.order = order;
        }
    }

    static int bfs(int startI, int startJ, int startD, int endI, int endJ, int endD) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startI, startJ, startD, 0));
        boolean[][][] dirVisited = new boolean[n][m][4];

        visited[startI][startJ] = true;
        dirVisited[startI][startJ][startD] = true;

        while (!q.isEmpty()) {
            Point newP = q.poll();
            int i = newP.i;
            int j = newP.j;
            int dir = newP.dir;
            int order = newP.order;

            if (i == endI && j == endJ && dir == endD) {
                return order;
            }

            int newI = i;
            int newJ = j;
            for (int k = 0; k < 3; k++) {
                newI += moveY[dir];
                newJ += moveX[dir];
                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m && !visited[newI][newJ]) {
                    if (factory[newI][newJ] == 0) {
                        q.add(new Point(newI, newJ, dir, order + 1));
                        visited[newI][newJ] = true;
                        dirVisited[newI][newJ][dir] = true;
                    } else {
                        break;
                    }
                }
            }

            int newDir;
            switch (dir) {
                case 0:
                case 1:
                    newDir = 2;
                    if (!dirVisited[i][j][newDir]) {
                        q.add(new Point(i, j, newDir, order + 1));
                        dirVisited[i][j][newDir] = true;
                    }
                    newDir = 3;
                    if (!dirVisited[i][j][newDir]) {
                        q.add(new Point(i, j, newDir, order + 1));
                        dirVisited[i][j][newDir] = true;
                    }
                    break;
                case 2:
                case 3:
                    newDir = 0;
                    if (!dirVisited[i][j][newDir]) {
                        q.add(new Point(i, j, newDir, order + 1));
                        dirVisited[i][j][newDir] = true;
                    }
                    newDir = 1;
                    if (!dirVisited[i][j][newDir]) {
                        q.add(new Point(i, j, newDir, order + 1));
                        dirVisited[i][j][newDir] = true;
                    }
                    break;
            }
        }
        return -1;
    }
}