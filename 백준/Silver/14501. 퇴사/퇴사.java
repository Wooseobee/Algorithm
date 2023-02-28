import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            t[i + 1] = Integer.parseInt(input[0]);
            p[i + 1] = Integer.parseInt(input[1]);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int finish = i + t[i];
            if (finish <= n + 1) {
                dp[finish] = Math.max(dp[finish], dp[i] + p[i]);
            }
        }

        System.out.println(Math.max(dp[n], dp[n + 1]));
        br.close();
    }
}