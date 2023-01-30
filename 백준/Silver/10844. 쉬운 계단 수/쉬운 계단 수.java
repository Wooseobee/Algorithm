import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        long cnt = 9;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            cnt = 0;
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % 1_000_000_000;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % 1_000_000_000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
                }
                if (i == n) cnt += (dp[i][j] % 1_000_000_000);
            }
        }
        System.out.println(cnt % 1_000_000_000);
        br.close();
    }
}