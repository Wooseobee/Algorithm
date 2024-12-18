import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] list;
    private static int[] cntArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] in = input.split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        list = new List[n + 1];
        cntArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine();
            in = input.split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);

            list[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            dfs(i, new boolean[n + 1]);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, cntArr[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (max == cntArr[i]) {
                System.out.print(i + " ");
            }
        }
        br.close();
    }

    private static void dfs(int i, boolean[] visited) {
        visited[i] = true;
        for (int next : list[i]) {
            if (!visited[next]) {
                visited[next] = true;
                cntArr[next]++;
                dfs(next, visited);
            }
        }
    }
}
