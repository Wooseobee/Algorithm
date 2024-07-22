import java.io.*;
import java.util.*;

public class Main {

    private static int n, l, r;
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static int[][] map;
    private static List<int[]> countries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        l = Integer.parseInt(in[1]);
        r = Integer.parseInt(in[2]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        System.out.println(move());
        br.close();
    }

    private static int move() {
        int day = 0;
        while (checkMap()) {
            day++;
        }
        return day;
    }

    private static boolean checkMap() {
        boolean isMove = false;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && open(i, j, visited)) {
                    isMove = true;
                }
            }
        }
        return isMove;
    }

    private static boolean open(int sI, int sJ, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        countries.clear();
        countries.add(new int[]{sI, sJ});
        q.add(new int[]{sI, sJ});
        visited[sI][sJ] = true;
        int population = map[sI][sJ];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];

            for (int d = 0; d < 4; d++) {
                int nI = i + dx[d];
                int nJ = j + dy[d];

                if (isIn(nI, nJ) && !visited[nI][nJ]) {
                    int abs = Math.abs(map[nI][nJ] - map[i][j]);
                    if (abs >= l && abs <= r) {
                        countries.add(new int[]{nI, nJ});
                        q.add(new int[]{nI, nJ});
                        population += map[nI][nJ];
                        visited[nI][nJ] = true;
                    }
                }
            }
        }

        int size = countries.size();
        if (size > 1) {
            for (int[] country : countries) {
                map[country[0]][country[1]] = population / size;
            }
            return true;
        } else {
            return false;
        }
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}
