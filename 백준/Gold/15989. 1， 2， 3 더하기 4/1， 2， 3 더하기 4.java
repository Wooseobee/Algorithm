import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[10001][4];
        int t = Integer.parseInt(br.readLine());

        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int j = 4; j <= 10000; j++) {
            dp[j][1] = dp[j - 1][1];
            dp[j][2] = dp[j - 2][1] + dp[j - 2][2];
            dp[j][3] = dp[j - 3][1] + dp[j - 3][2] + dp[j - 3][3];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
