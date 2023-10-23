import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static int[][] broken;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[1]);
        m = Integer.parseInt(in[0]);

        map = new int[n][m];
        broken = new int[n][m];

        for (int i = 0; i < n; i++) {
            in = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(in[j]);
                broken[i][j] = n * m;
            }
        }
        bfs();

        System.out.println(broken[n - 1][m - 1]);
        br.close();
    }

    private static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{0, 0, 0});
        broken[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int i = now[0];
            int j = now[1];
            int breakCnt = now[2];
            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (in(nI, nJ)) {
                    if (map[nI][nJ] == 1 && broken[nI][nJ] > breakCnt + 1) {
                        pq.add(new int[]{nI, nJ, breakCnt + 1});
                        broken[nI][nJ] = breakCnt + 1;
                    } else if (map[nI][nJ] == 0 && broken[nI][nJ] > breakCnt) {
                        pq.add(new int[]{nI, nJ, breakCnt});
                        broken[nI][nJ] = breakCnt;
                    }
                }
            }
        }
    }

    private static boolean in(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}