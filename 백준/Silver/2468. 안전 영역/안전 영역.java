import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] area;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int highest = 0;

        area = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
                highest = Math.max(highest, area[i][j]);
            }
        }

        int max = 0;
        for (int i = 0; i <= highest; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && area[j][k] > i) {
                        cnt++;
                        dfs(j, k, i);
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[j], false);
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
        br.close();
    }

    private static void dfs(int i, int j, int height) {
        if (visited[i][j]) return;

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (i + moveY[k] >= 0 && j + moveX[k] >= 0 && i + moveY[k] < n && j + moveX[k] < n) {
                if (area[i + moveY[k]][j + moveX[k]] > height) {
                    dfs(i + moveY[k], j + moveX[k], height);
                }
            }
        }
    }
}