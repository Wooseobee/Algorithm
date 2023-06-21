import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static int[][] map;
    static int[][] emptyMap;
    static List<int[]> emptyAreaList = new ArrayList<>();
    static List<int[]> virusList = new ArrayList<>();
    static boolean[] checked;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                if (map[i][j] == 0) emptyAreaList.add(new int[]{i, j});
                else if (map[i][j] == 2) virusList.add(new int[]{i, j});
            }
        }
        checked = new boolean[emptyAreaList.size()];
        backTracking(0, 0);

        System.out.println(max);
        br.close();
    }

    private static void backTracking(int depth, int idx) {
        if (depth == 3) {
            emptyMap = new int[n][m];
            checkMaxArea();
            return;
        }
        for (int i = idx; i < emptyAreaList.size(); i++) {
            if (!checked[i]) {
                int[] coords = emptyAreaList.get(i);

                map[coords[0]][coords[1]] = 1;
                checked[i] = true;

                backTracking(depth + 1, i);

                map[coords[0]][coords[1]] = 0;
                checked[i] = false;
            }
        }
    }

    private static void checkMaxArea() {
        for (int i = 0; i < n; i++) {
            emptyMap[i] = Arrays.copyOf(map[i], m);
        }
        for (int[] coords : virusList) {
            spreadVirus(coords);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (emptyMap[i][j] == 0) cnt++;
            }
        }
        max = Math.max(max, cnt);
    }

    private static void spreadVirus(int[] coords) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{coords[0], coords[1]});
        boolean[][] visited = new boolean[n][m];
        visited[coords[0]][coords[1]] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            for (int k = 0; k < 4; k++) {
                int newI = i + dy[k];
                int newJ = j + dx[k];
                if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                    if (!visited[newI][newJ] && emptyMap[newI][newJ] == 0) {
                        visited[newI][newJ] = true;
                        emptyMap[newI][newJ] = 2;
                        q.add(new int[]{newI, newJ});
                    }
                }
            }
        }
    }
}