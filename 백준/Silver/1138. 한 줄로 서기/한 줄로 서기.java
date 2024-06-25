import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] ans;
    private static boolean[] visited;
    private static String[] in;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        ans = new int[n];
        visited = new boolean[n];
        Arrays.fill(ans, -1);

        backTracking(0);

        System.out.print(sb);
        br.close();
    }

    private static void backTracking(int depth) {
        if (depth == n) {
            if (checkLine()) {
                for (int j = 0; j < n; j++) {
                    sb.append(ans[j] + 1).append(" ");
                }
            }
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                visited[j] = true;
                ans[depth] = j;
                backTracking(depth + 1);
                visited[j] = false;
            }
        }
    }

    private static boolean checkLine() {
        for (int i = 0; i < n; i++) {
            int left = Integer.parseInt(in[ans[i]]);

            int cnt = 0;
            for (int j = 0; j < i; j++) {
                int now = ans[j];
                if (now > ans[i]) {
                    cnt++;
                }
            }

            if (cnt != left) {
                return false;
            }
        }
        return true;
    }
}
