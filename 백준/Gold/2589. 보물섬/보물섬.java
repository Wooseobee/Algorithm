import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt, max = Integer.MIN_VALUE, startI, startJ, endI, endJ, min = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 'L') {
                    cnt = 0;
                    searchTreasure(i, j);
                    for (int k = 0; k < n; k++) {
                        Arrays.fill(visited[k], false);
                    }
                }
            }
        }

        for (int k = 0; k < n; k++) {
            Arrays.fill(visited[k], false);
        }

        bfs(startI, startJ);
        System.out.println(min);

        br.close();
    }

    static class Land {
        int i;
        int j;
        int count;

        public Land(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    static void searchTreasure(int i, int j) {
        Queue<Land> q = new LinkedList<>();
        q.add(new Land(i, j, 0));

        while (!q.isEmpty()) {
            Land land = q.poll();
            int x = land.j;
            int y = land.i;
            int count = land.count;
            if (visited[y][x]) continue;
            visited[y][x] = true;

            for (int k = 0; k < 4; k++) {
                if (y + moveY[k] >= 0 && x + moveX[k] >= 0 && y + moveY[k] < n && x + moveX[k] < m && map[y + moveY[k]][x + moveX[k]] == 'L' && !visited[y + moveY[k]][x + moveX[k]]) {
                    q.add(new Land(y + moveY[k], x + moveX[k], count + 1));
                }
            }
            if (max < count) {
                startI = i;
                startJ = j;
                endI = y;
                endJ = x;
                max = count;
            }
        }
    }

    static void bfs(int i, int j) {
        Queue<Land> q = new LinkedList<>();
        q.add(new Land(i, j, 0));

        while (!q.isEmpty()) {
            Land land = q.poll();
            int x = land.j;
            int y = land.i;
            int count = land.count;
            if (visited[y][x]) continue;
            visited[y][x] = true;

            for (int k = 0; k < 4; k++) {
                if (y + moveY[k] >= 0 && x + moveX[k] >= 0 && y + moveY[k] < n && x + moveX[k] < m && map[y + moveY[k]][x + moveX[k]] == 'L') {
                    q.add(new Land(y + moveY[k], x + moveX[k], count + 1));
                }
            }
            if (x == endJ && y == endI) min = Math.min(min, count);
        }
    }
}