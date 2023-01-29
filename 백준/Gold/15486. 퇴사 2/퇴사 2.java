import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 2];
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            t[i + 1] = Integer.parseInt(input[0]);
            p[i + 1] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }
        System.out.println(Math.max(dp[n], dp[n + 1]));
        br.close();
    }
}