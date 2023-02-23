import java.io.*;
import java.util.*;

public class Main {
    static class road {
        int v;
        int w;

        public road(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<road>[] list;
    static int[] dist;
    static boolean[] visited;

    static int n;
    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);

        list = new List[n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < e; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            list[a].add(new road(b, c));
            list[b].add(new road(a, c));
        }
        s = br.readLine().split(" ");

        int v1 = Integer.parseInt(s[0]);
        int v2 = Integer.parseInt(s[1]);
        int total1 = 0, total2 = 0;

        total1 += dijkstra(1, v1);
        total1 += dijkstra(v1, v2);
        total1 += dijkstra(v2, n);

        total2 += dijkstra(1, v2);
        total2 += dijkstra(v2, v1);
        total2 += dijkstra(v1, n);

        if (total1 >= INF && total2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(total1, total2));
        }

        br.close();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<road> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        pq.add(new road(start, 0));

        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            road now = pq.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                for (road next : list[now.v]) {
                    if (dist[next.v] > now.w + next.w){
                        dist[next.v] = now.w + next.w;
                        pq.add(new road(next.v, dist[next.v]));
                    }
                }
            }

        }
        return dist[end];
    }
}