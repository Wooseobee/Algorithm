import java.util.*;
import java.io.*;

public class Main {

    private static int n, m, r, max = 0;
    private static int[] items;
    private static int[] dist;
    private static List[] roads;

    private static class Edge {
        int v;
        int d;

        public Edge(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        r = Integer.parseInt(in[2]);

        items = new int[n + 1];
        dist = new int[n + 1];
        roads = new List[n + 1];

        in = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
            items[i] = Integer.parseInt(in[i - 1]);
        }

        for (int i = 0; i < r; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int l = Integer.parseInt(in[2]);

            roads[a].add(new Edge(b, l));
            roads[b].add(new Edge(a, l));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[j] = 2_001;
            }
            bfs(i);
        }

        System.out.println(max);
        br.close();
    }

    private static void bfs(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] visited = new boolean[n + 1];
        pq.add(new int[]{s, 0});
        int total = 0;
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int v = now[0];
            int d = now[1];
            if (visited[v]) continue;
            visited[v] = true;

            total += items[v];

            for (Edge next : (ArrayList<Edge>) roads[v]) {
                int nV = next.v;
                int nD = next.d;
                if (dist[nV] > d + nD && d + nD <= m){
                    pq.add(new int[]{nV, d + nD});
                }
            }
        }
        max = Math.max(max, total);
    }
}