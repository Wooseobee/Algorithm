import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int n, m;
    static int[] NEW_X = {-1, 1, 0, 0};
    static int[] NEW_Y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            arr[r][c] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            cnt++;
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_x = now[0] + NEW_X[i];
                int new_y = now[1] + NEW_Y[i];
                if (new_x >= 0 && new_y >= 0 && new_x <= n && new_y <= m) {
                    if (!visited[new_x][new_y] && arr[new_x][new_y] == 1) {
                        visited[new_x][new_y] = true;
                        q.add(new int[]{new_x, new_y});
                    }
                }
            }
        }
        if (cnt > max) {
            max = cnt;
        }
    }
}