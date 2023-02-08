import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n, m;
    static int[] tomatoStatus;
    static int[][] storage;
    static boolean[][] visited;
    static List<Point> list;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    static class Point {
        int i;
        int j;
        int day;

        public Point(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[0]);

        tomatoStatus = new int[3];
        storage = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                storage[i][j] = Integer.parseInt(input[j]);
                if (storage[i][j] == -1) tomatoStatus[0]++;
                else if (storage[i][j] == 0) tomatoStatus[1]++;
                else {
                    tomatoStatus[2]++;
                    list.add(new Point(i, j, 0));
                }
            }
        }

        if (tomatoStatus[0] + tomatoStatus[2] == n * m) {
            System.out.println(0);
        } else {
            System.out.println(bfs());
        }
        br.close();
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();

        for (Point p : list) {
            q.add(p);
            visited[p.i][p.j] = true;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.day!=0) {
                tomatoStatus[1]--;
                tomatoStatus[2]++;
            }

            if (tomatoStatus[1] == 0 || tomatoStatus[0] + tomatoStatus[1] == n * m) {
                return p.day;
            }

            for (int i = 0; i < 4; i++) {
                int newI = p.i + moveY[i];
                int newJ = p.j + moveX[i];
                int day = p.day;
                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (!visited[newI][newJ] && storage[newI][newJ] == 0) {
                        q.add(new Point(newI, newJ, day + 1));
                        visited[newI][newJ] = true;
                        storage[newI][newJ] = 1;
                    }
                }
            }
        }

        return -1;
    }
}