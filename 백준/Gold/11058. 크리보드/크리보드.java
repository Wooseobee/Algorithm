import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= n; i++) {
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - 1] + 1, dp[j] * (i - j - 1)));
            }
        }
        System.out.println(dp[n]);
        br.close();
    }
}