import java.io.*;
import java.util.*;

public class Main {

    private static int n, max = 0;
    private static int[][] eggs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int w = Integer.parseInt(in[1]);

            eggs[i][0] = s;
            eggs[i][1] = w;
        }

        backTracking(0);
        System.out.println(max);
        br.close();
    }

    private static void backTracking(int depth) {
        if (depth == n) {
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i][0] <= 0) {
                    total++;
                }
            }
            max = Math.max(max, total);
            return;
        }

        boolean breakEgg = false;
        int weight = eggs[depth][1];
        if (eggs[depth][0] > 0) {
            for (int i = 0; i < n; i++) {
                if (i == depth || eggs[i][0] <= 0) {
                    continue;
                }
                breakEgg = true;
                int now = eggs[i][1];
                eggs[i][0] -= weight;
                eggs[depth][0] -= now;
                backTracking(depth + 1);
                eggs[i][0] += weight;
                eggs[depth][0] += now;
            }
        }
        if (!breakEgg) {
            backTracking(depth + 1);
        }
    }
}
