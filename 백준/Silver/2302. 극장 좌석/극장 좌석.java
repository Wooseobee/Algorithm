import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int before = 0;
        int ans = 1;
        for (int i = 0; i < m; i++) {
            int seat = Integer.parseInt(br.readLine());
            ans *= dp[seat - before - 1];
            before = seat;
        }
        ans *= dp[n - before];

        System.out.println(ans);
        br.close();
    }
}
