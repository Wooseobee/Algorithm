import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int[] order;
    private static int depth = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int r = Integer.parseInt(in[2]);

        visited = new boolean[n + 1];
        order = new int[n + 1];
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int u = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);

            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int u) {
        visited[u] = true;
        order[u] = depth++;
        for (int next : list[u]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}