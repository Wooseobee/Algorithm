import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// knapsack 알고리즘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] dp = new int[n + 1][k + 1];
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            w[i] = Integer.parseInt(input[0]);
            v[i] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - w[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
        br.close();
    }
}