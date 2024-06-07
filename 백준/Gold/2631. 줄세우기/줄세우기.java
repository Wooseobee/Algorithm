import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n];
        int[] dp = new int[n];
        int totalMax = 0;

        for (int i = 0; i < n; i++) {
            int child = Integer.parseInt(br.readLine());
            line[i] = child;
        }

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (line[i] > line[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            totalMax = Math.max(totalMax, dp[i]);
        }

        System.out.println(n - totalMax);
        br.close();
    }

}
