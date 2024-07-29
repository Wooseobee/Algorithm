import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] minDp = new long[101];

        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10;

        String[] add = {"1", "7", "4", "2", "0", "8"};

        for (int i = 9; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String str = minDp[i - j] + add[j - 2];
                minDp[i] = Math.min(minDp[i], Long.parseLong(str));
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(minDp[n]).append(" ");
            if (n % 2 == 0) {
                sb.append("1");
            } else {
                sb.append("7");
            }

            for (int j = 1; j < n / 2; j++) {
                sb.append("1");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
