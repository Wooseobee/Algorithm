import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int[] New_x = {-1, 1, 0, 0};
    static int[] New_y = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            s = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        visited[1][1] = true;
        bfs(1, 1);

        System.out.println(arr[n][m]);
        br.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_x = now[0] + New_x[i];
                int new_y = now[1] + New_y[i];
                if (new_x >= 0 && new_y >= 0 && new_x <= n && new_y <= m) {
                    if (arr[new_x][new_y] == 1 && !visited[new_x][new_y]) {
                        arr[new_x][new_y] = arr[now[0]][now[1]] + 1;
                        q.add(new int[]{new_x, new_y});
                        visited[new_x][new_y] = true;
                    }
                }
            }
        }
    }
}