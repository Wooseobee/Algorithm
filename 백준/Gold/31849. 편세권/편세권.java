import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int min = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    private static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        int r = Integer.parseInt(in[2]);
        int c1 = Integer.parseInt(in[3]);
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < r; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int p = Integer.parseInt(in[2]);

            map[a][b] = p;
        }

        for (int i = 0; i < c1; i++) {
            in = br.readLine().split(" ");
            int c = Integer.parseInt(in[0]);
            int d = Integer.parseInt(in[1]);

            q.add(new int[]{c, d, 0});
            visited[c][d] = true;
        }

        bfs();

        System.out.println(min);
        br.close();
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int dist = now[2];

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (isIn(nI, nJ) && !visited[nI][nJ]) {
                    visited[nI][nJ] = true;
                    q.add(new int[]{nI, nJ, dist + 1});

                    int p = map[nI][nJ];
                    if (p != 0) {
                        min = Math.min(min, (dist + 1) * p);
                    }
                }
            }
        }
    }

    private static boolean isIn(int nI, int nJ) {
        return nI > 0 && nJ > 0 && nI <= n && nJ <= m;
    }
}
