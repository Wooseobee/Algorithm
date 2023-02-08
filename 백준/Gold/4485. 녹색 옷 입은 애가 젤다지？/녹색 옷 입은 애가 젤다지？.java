import java.io.*;
import java.util.*;

public class Main {
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }
            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(input[j]);
                }
            }

            cnt++;
            sb.append("Problem ").append(cnt).append(": ").append(dijkstra(n, cave)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Point {
        int i;
        int j;
        int total;

        public Point(int i, int j, int total) {
            this.i = i;
            this.j = j;
            this.total = total;
        }
    }

    static int dijkstra(int n, int[][] cave) {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.total - o2.total);
        pq.add(new Point(0, 0, cave[0][0]));
        visited[0][0] = true;

        int total = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.i == n - 1 && p.j == n - 1) {
                total = p.total;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newI = p.i + moveY[i];
                int newJ = p.j + moveX[i];

                if (newI >= 0 && newJ >= 0 && newI < n && newJ < n) {
                    if (!visited[newI][newJ]) {
                        pq.add(new Point(newI, newJ, p.total + cave[newI][newJ]));
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
        return total;
    }
}