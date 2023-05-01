import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int i;
        int j;
        int moveCount;
        int brokenCount;

        public Point(int i, int j, int moveCount, int brokenCount) {
            this.i = i;
            this.j = j;
            this.moveCount = moveCount;
            this.brokenCount = brokenCount;
        }
    }

    static int n, m, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[][][] brokenVisited = new boolean[n][m][k + 1]; // (n,m) k번 부순 길
        q.add(new Point(0, 0, 1, 0));
        Arrays.fill(brokenVisited[0][0], true);

        while (!q.isEmpty()) {
            Point now = q.poll();
            int breakCount = now.brokenCount;

            if (now.i == n - 1 && now.j == m - 1) {
                return now.moveCount;
            }
            for (int i = 0; i < 4; i++) {
                int newI = now.i + dy[i];
                int newJ = now.j + dx[i];
                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (arr[newI][newJ] == 0) { // 벽이 없을 때
                        if (!brokenVisited[newI][newJ][breakCount]) {
                            q.add(new Point(newI, newJ, now.moveCount + 1, breakCount));
                            brokenVisited[newI][newJ][breakCount] = true;
                        }
                    } else {    // 벽이 있을 때
                        if (breakCount < k && !brokenVisited[newI][newJ][breakCount + 1]) {
                            q.add(new Point(newI, newJ, now.moveCount + 1, breakCount + 1));
                            brokenVisited[newI][newJ][breakCount + 1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}