import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    private static char[][] map;
    private static int[][] jihun;
    private static int[][] fire;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        map = new char[n][m];
        jihun = new int[n][m];
        fire = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(jihun[i], -1);
        }

        Queue<int[]> jQ = new LinkedList<>();
        Queue<int[]> fQ = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'J') {
                    jihun[i][j] = 0;
                    jQ.add(new int[]{i, j});
                } else if (map[i][j] == 'F') {
                    fire[i][j] = 0;
                    fQ.add(new int[]{i, j});
                }
            }
        }

        int res = bfs(jQ, fQ);
        System.out.println(res == -1 ? "IMPOSSIBLE" : res);
        br.close();
    }

    private static int bfs(Queue<int[]> jQ, Queue<int[]> fQ) {
        while (!fQ.isEmpty()) {
            int[] now = fQ.poll();
            int i = now[0];
            int j = now[1];
            int moveCnt = fire[i][j];

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (isIn(nI, nJ) && map[nI][nJ] != '#' && fire[nI][nJ] == -1) {
                    fQ.add(new int[]{nI, nJ});
                    fire[nI][nJ] = moveCnt + 1;
                }
            }
        }

        while (!jQ.isEmpty()) {
            int[] now = jQ.poll();
            int i = now[0];
            int j = now[1];
            int moveCnt = jihun[i][j];

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (isIn(nI, nJ)) {
                    if (map[nI][nJ] == '.' && (fire[nI][nJ] > moveCnt + 1 || fire[nI][nJ] == -1) && jihun[nI][nJ] == -1) {
                        jQ.add(new int[]{nI, nJ});
                        jihun[nI][nJ] = moveCnt + 1;
                    }
                } else {
                    return moveCnt + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
