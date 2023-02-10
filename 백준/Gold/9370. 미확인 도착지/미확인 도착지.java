import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int n, m, t, s, g, h;

    static class Road {
        int v;
        int w;

        public Road(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            List<List<Road>> graph = new ArrayList<>();
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            t = Integer.parseInt(input[2]);

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }
            input = br.readLine().split(" ");
            s = Integer.parseInt(input[0]);
            g = Integer.parseInt(input[1]);
            h = Integer.parseInt(input[2]);

            for (int j = 0; j < m; j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int d = Integer.parseInt(input[2]);
                graph.get(a).add(new Road(b, d));
                graph.get(b).add(new Road(a, d));
            }

            List<Integer> candidate = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                candidate.add(Integer.parseInt(br.readLine()));
            }
            
            int[] dist = dijkstra(s, graph);
            int[] gDist = dijkstra(g, graph);
            int[] hDist = dijkstra(h, graph);

            sb.append(canGo(dist, gDist, hDist, candidate)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static String canGo(int[] dist, int[] gDist, int[] hDist, List<Integer> candidate) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int destination : candidate) {
            if (dist[destination] == dist[g] + gDist[h] + hDist[destination] ||
                    dist[destination] == dist[h] + hDist[g] + gDist[destination]) {
                pq.add(destination);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        
        return sb.toString();
    }

    static int[] dijkstra(int start, List<List<Road>> graph) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new Road(start, 0));

        while (!pq.isEmpty()) {
            Road now = pq.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                for (Road next : graph.get(now.v)) {
                    dist[next.v] = Math.min(dist[next.v], now.w + next.w);
                    pq.add(new Road(next.v, dist[next.v]));
                }
            }
        }
        
        return dist;
    }
}