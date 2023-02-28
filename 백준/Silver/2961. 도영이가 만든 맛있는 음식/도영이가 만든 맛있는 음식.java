import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] s, b;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            s[i] = Integer.parseInt(str[0]);
            b[i] = Integer.parseInt(str[1]);
        }

        dfs(0, 0, 1, 0);

        System.out.println(min);
        br.close();
    }

    static void dfs(int idx, int depth, int totalS, int totalB) {
        if (idx == n) {
            if (depth != 0) min = Math.min(min, Math.abs(totalS - totalB));
            return;
        }
        dfs(idx + 1, depth, totalS, totalB);
        dfs(idx + 1, depth + 1, totalS * s[idx], totalB + b[idx]);
    }
}