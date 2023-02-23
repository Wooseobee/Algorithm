import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map, dp;
    static boolean[][] visited;
    static int[] moveX = new int[]{-1, 1, 0, 0};
    static int[] moveY = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 0));
        br.close();
    }

    static int dfs(int i, int j) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            if (i + moveY[k] >= 0 && j + moveX[k] >= 0 && i + moveY[k] < n && j + moveX[k] < m && map[i][j] > map[i + moveY[k]][j + moveX[k]]) {
                dp[i][j] += dfs(i + moveY[k], j + moveX[k]);
            }
        }

        return dp[i][j];
    }
}