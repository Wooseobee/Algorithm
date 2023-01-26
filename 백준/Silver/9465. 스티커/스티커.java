import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(new StringBuilder());

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][n];
            int[][] dp = new int[2][n];
            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(input[k]);
                }
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if (n >= 2) {
                dp[0][1] = stickers[0][1] + stickers[1][0];
                dp[1][1] = stickers[1][1] + stickers[0][0];
            }
            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 2], dp[1][j - 1]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 2], dp[0][j - 1]) + stickers[1][j];
            }
            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1]) + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}