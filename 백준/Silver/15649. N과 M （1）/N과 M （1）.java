import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[m];
        visited = new boolean[n];

        backTracking(0, n, m);
        System.out.println(sb);
        br.close();
    }

    public static void backTracking(int idx, int n, int m) {
        if (idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                arr[idx] = i + 1;
                backTracking(idx + 1, n, m);

                visited[i] = false;
            }
        }
    }
}