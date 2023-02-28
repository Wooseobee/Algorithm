import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] s,b, choice;
    static boolean[] visited;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = new int[n];
        b = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            s[i] = Integer.parseInt(str[0]);
            b[i] = Integer.parseInt(str[1]);
        }

        for (int i = 1; i <= n; i++) {
            choice = new int[i];
            dfs(0, 0, i);
        }

        System.out.println(min);
        br.close();
    }

    static void dfs(int start, int depth, int size) {
        if (depth == size) {
            findMin(size);
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                choice[depth] = i;
                dfs(i, depth + 1, size);

                visited[i] = false;
            }
        }
    }

    private static void findMin(int size) {
        long totalS = 1;
        long totalB = 0;
        for (int i = 0; i < size; i++) {
            int idx = choice[i];
            totalS *= s[idx];
            totalB += b[idx];
        }
        min = Math.min(min, Math.abs(totalS - totalB));
    }
}