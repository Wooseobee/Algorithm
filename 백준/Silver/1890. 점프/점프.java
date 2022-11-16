import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        int[][] board = new int[n][n];
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = board[i][j];
                if (i == n - 1 && j == n - 1) {
                    continue;
                }
                if (j + num < n && num != 0) {
                    dp[i][j + num] += dp[i][j];
                }
                if (i + num < n && num != 0) {
                    dp[i + num][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}