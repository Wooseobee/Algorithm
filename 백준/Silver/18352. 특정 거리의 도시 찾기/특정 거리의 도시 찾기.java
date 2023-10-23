import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, k, x, total = 0;
    private static int[] dist;
    private static List[] roads;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        k = Integer.parseInt(in[2]);
        x = Integer.parseInt(in[3]);

        roads = new List[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
            dist[i] = 300_001;
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            roads[a].add(b);
        }

        dijkstra();

        for (int i = 1; i <= n; i++) {
            if (i != x && dist[i] == k) {
                total++;
                sb.append(i).append("\n");
            }
        }
        if (total == 0) {
            sb.append("-1");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[n + 1];
        dist[x] = 0;
        pq.add(new int[]{x, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            for (int next : (ArrayList<Integer>) roads[now[0]]) {
                int d = dist[now[0]] + 1;
                if (dist[next] > d) {
                    pq.add(new int[]{next, d});
                    dist[next] = d;
                }
            }
        }
    }
}