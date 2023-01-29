import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coins = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            coins[i + 1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= coins[j]) {
                    dp[j][i] = dp[j - 1][i] + dp[j][i - coins[j]];
                } else {
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }
        System.out.println(dp[n][k]);
        br.close();
    }
}