import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] boxes = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(input[i]);
        }

        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int idx = i - 1;
            while (idx >= 0) {
                if (boxes[i] > boxes[idx]) {
                    dp[i] = Math.max(dp[i], dp[idx] + 1);
                }
                idx--;
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }
}