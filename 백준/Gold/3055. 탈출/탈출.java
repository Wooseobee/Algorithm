import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[] s, d;
    private static List<int[]> water;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        map = new String[n][m];
        s = new int[2];
        d = new int[2];
        water = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            in = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = in[j];
                switch (map[i][j]) {
                    case "D":
                        d[0] = i;
                        d[1] = j;
                        break;
                    case "S":
                        s[0] = i;
                        s[1] = j;
                        break;
                    case "*":
                        water.add(new int[]{i, j});
                        break;
                }
            }
        }

        int ans = move();

        System.out.println(ans == -1 ? "KAKTUS" : ans);
        br.close();
    }

    private static int move() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int[] w : water) {
            q.add(new int[]{w[0], w[1], 0});
            visited[w[0]][w[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int cnt = now[2];

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];

                if (in(nI, nJ) && map[nI][nJ].equals(".") && !visited[nI][nJ]) {
                    map[nI][nJ] = String.valueOf(cnt + 1);
                    q.add(new int[]{nI, nJ, cnt + 1});
                    visited[nI][nJ] = true;
                }
            }
        }

        visited = new boolean[n][m];
        q.add(new int[]{s[0], s[1], 0});
        visited[s[0]][s[1]] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int cnt = now[2];

            if (map[i][j].equals("D")) return cnt;

            for (int k = 0; k < 4; k++) {
                int nI = i + dx[k];
                int nJ = j + dy[k];
                if (in(nI, nJ) && (map[nI][nJ].equals(".") || map[nI][nJ].equals("D") || (map[nI][nJ].replaceAll("[0-9]", "").length() == 0 && cnt + 1 < Integer.parseInt(map[nI][nJ]))) && !visited[nI][nJ]) {
                    q.add(new int[]{nI, nJ, cnt + 1});
                    visited[nI][nJ] = true;
                }
            }
        }
        return -1;
    }

    private static boolean in(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}