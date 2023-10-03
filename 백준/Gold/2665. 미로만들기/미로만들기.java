import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        for (int i = 0; i <= 2 * n - 3; i++) {
            if (canGo(i)) {
                System.out.println(i);
                break;
            }
        }

        br.close();
    }

    private static boolean canGo(int maxBreakCnt) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][n][2 * n - 2];
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int breakCnt = now[2];

            if (i == n - 1 && j == n - 1) return true;

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (in(nI, nJ) && !visited[nI][nJ][breakCnt]) {
                    if (map[nI][nJ] == 0) {
                        if (breakCnt < maxBreakCnt) {
                            q.add(new int[]{nI, nJ, breakCnt + 1});
                            visited[nI][nJ][breakCnt + 1] = true;
                        }
                    } else {
                        q.add(new int[]{nI, nJ, breakCnt});
                        visited[nI][nJ][breakCnt] = true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean in(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}