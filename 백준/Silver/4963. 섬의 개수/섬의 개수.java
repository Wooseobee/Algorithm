import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] moveY = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");

            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);

            if (w == 0 && h == 0) break;

            cnt = 0;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            findIsland(w, h);

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void findIsland(int w, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    dfs(j, i, w, h);
                }
            }
        }
    }

    static void dfs(int x, int y, int w, int h) {
        if (visited[y][x] || map[y][x] == 0) return;

        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            if (x + moveX[i] >= 0 && x + moveX[i] < w && y + moveY[i] >= 0 && y + moveY[i] < h && !visited[y + moveY[i]][x + moveX[i]]) {
                dfs(x + moveX[i], y + moveY[i], w, h);
            }
        }
    }
}