import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int cnt, total = 0;
    static char[][] field;
    static boolean[][] removed;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];
        removed = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                field[i][j] = input[j].charAt(0);
            }
        }

        do {
            cnt = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.') {
                        bfs(i, j, field[i][j]);
                    }
                }
            }
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (removed[i][j]) {
                        setField(i, j);
                    }
                }
            }
            if (cnt > 0) {
                total++;
            }
            for (int i = 0; i < 12; i++) {
                Arrays.fill(removed[i], false);
            }
        } while (cnt != 0);

        System.out.println(total);
    }

    static class Point {
        int i;
        int j;
        char color;

        public Point(int i, int j, char color) {
            this.i = i;
            this.j = j;
            this.color = color;
        }
    }

    static void bfs(int i, int j, char color) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j, color));
        int colors = 1;
        boolean[][] visited = new boolean[12][6];
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point newP = q.poll();

            for (int k = 0; k < 4; k++) {
                int newI = newP.i + moveY[k];
                int newJ = newP.j + moveX[k];
                if (newI >= 0 && newJ >= 0 && newI < 12 && newJ < 6) {
                    if (!visited[newI][newJ] && field[newI][newJ] == color) {
                        q.add(new Point(newI, newJ, color));
                        visited[newI][newJ] = true;
                        colors++;
                    }
                }
            }
        }
        if (colors >= 4) {
            cnt++;
            removeField(i, j, color);
        }
    }

    static void removeField(int i, int j, char color) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j, color));
        boolean[][] visited = new boolean[12][6];
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Point newP = q.poll();

            field[newP.i][newP.j] = '.';
            removed[newP.i][newP.j] = true;

            for (int k = 0; k < 4; k++) {
                int newI = newP.i + moveY[k];
                int newJ = newP.j + moveX[k];
                if (newI >= 0 && newJ >= 0 && newI < 12 && newJ < 6) {
                    if (!visited[newI][newJ] && field[newI][newJ] == color) {
                        q.add(new Point(newI, newJ, color));
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
    }

    static void setField(int i, int j) {
        for (int k = i; k > 0; k--) {
            field[k][j] = field[k - 1][j];
        }
        field[0][j] = '.';
    }
}