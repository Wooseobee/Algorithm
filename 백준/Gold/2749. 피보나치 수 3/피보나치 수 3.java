import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int PISANO = 1_500_000;
        long n = Long.parseLong(br.readLine()) % PISANO;

        long[] dp = new long[PISANO + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= PISANO; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000;
        }

        System.out.println(dp[(int) n]);
        br.close();
    }
}
