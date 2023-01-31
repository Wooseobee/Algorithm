import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j, n);
                    pq.add(cnt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");

        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void dfs(int x, int y, int n) {
        if (map[x][y] == 0 || visited[x][y]) return;

        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            if (x + moveX[i] >= 0 && y + moveY[i] >= 0 && x + moveX[i] < n && y + moveY[i] < n) {
                dfs(x + moveX[i], y + moveY[i], n);
            }
        }
    }
}