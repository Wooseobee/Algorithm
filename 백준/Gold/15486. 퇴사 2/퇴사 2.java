import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;

        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");

            t[i] = Integer.parseInt(s[0]);
            p[i] = Integer.parseInt(s[1]);
        }

        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);

            int day = i + t[i];
            if (day <= n + 1) {
                dp[day] = Math.max(max + p[i], dp[day]);
            }
        }
        System.out.println(max);
        br.close();
    }
}