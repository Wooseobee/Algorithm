import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, sI, sJ;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        map = new int[n][m];
        visited= new boolean[n][m];
        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                if (map[i][j] == 2) {
                    sI = i;
                    sJ = j;
                    map[i][j] = -2;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1);
                } else if (map[i][j] == -2) {
                    sb.append(0);
                } else {
                    sb.append(map[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sI, sJ, 0});
        visited[sI][sJ] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int dist = now[2];

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (isIn(nI, nJ) && map[nI][nJ] == 1 && !visited[nI][nJ]) {
                    map[nI][nJ] = dist + 1;
                    visited[nI][nJ] = true;
                    q.add(new int[]{nI, nJ, dist + 1});
                }
            }
        }
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
