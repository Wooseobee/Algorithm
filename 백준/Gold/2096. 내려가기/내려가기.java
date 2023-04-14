import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[0][i] = num;
            minDp[0][i] = num;
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            maxDp[i][0] = num1 + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = num2 + Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2]));
            maxDp[i][2] = num3 + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);
            minDp[i][0] = num1 + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = num2 + Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2]));
            minDp[i][2] = num3 + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }

        System.out.println(Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2])) + " " + Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2])));
        br.close();
    }
}