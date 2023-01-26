import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                tri[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = tri[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 ) {
                    dp[i][j] = dp[i - 1][j] + tri[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j-1], dp[i - 1][j]) + tri[i][j];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }
        System.out.println(max);
        br.close();
    }
}