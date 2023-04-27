import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int v, max = 0, maxV = 1;
    static List<Edge>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());
        tree = new List[v + 1];
        visited = new boolean[v + 1];
        for (int i = 0; i < v + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1) continue;
                int w = Integer.parseInt(st.nextToken());

                tree[n].add(new Edge(v2, w));
            }
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(maxV, 0);

        System.out.println(max);
        br.close();
    }

    private static void dfs(int i, int w) {
        if (visited[i]) return;
        if (max < w) {
            max = w;
            maxV = i;
        }
        visited[i] = true;

        for (Edge e : tree[i]) {
            dfs(e.v, w + e.w);
        }
    }
}