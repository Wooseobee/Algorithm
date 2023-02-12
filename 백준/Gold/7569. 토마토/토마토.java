import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h, day = -1;
    static int[][][] box;
    static int[] moveX = new int[]{-1, 1, 0, 0, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1, 0, 0};
    static int[] moveZ = new int[]{0, 0, 0, 0, -1, 1};
    static int[] tomatoStatus = new int[3];
    static List<Point> startList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[2]);

        box = new int[n][m][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                input = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    box[j][k][i] = Integer.parseInt(input[k]);
                    if (box[j][k][i] == -1) tomatoStatus[0]++;
                    else if (box[j][k][i] == 0) tomatoStatus[1]++;
                    else {
                        startList.add(new Point(k, j, i, 0));
                        tomatoStatus[2]++;
                    }
                }
            }
        }

        if (tomatoStatus[1] == 0) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(day);
        }

        br.close();
    }

    static class Point {
        int x;
        int y;
        int z;
        int cnt;

        public Point(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        for (Point p : startList) {
            q.add(new Point(p.x, p.y, p.z, p.cnt));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (tomatoStatus[1] == 0) {
                day = p.cnt;
            }

            for (int i = 0; i < 6; i++) {
                int newX = p.x + moveX[i];
                int newY = p.y + moveY[i];
                int newZ = p.z + moveZ[i];

                if (newX >= 0 && newY >= 0 && newZ >= 0 && newX < m && newY < n && newZ < h) {
                    if (box[newY][newX][newZ] == 0) {
                        q.add(new Point(newX, newY, newZ, p.cnt + 1));
                        box[newY][newX][newZ] = 1;
                        tomatoStatus[1]--;
                        tomatoStatus[2]++;
                    }
                }
            }
        }
    }
}