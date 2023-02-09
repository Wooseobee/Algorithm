import java.io.*;
import java.util.*;

public class Main {
    static long[] dist;
    static final long INF = Long.MAX_VALUE;
    static List<Edge> edges = new ArrayList<>();

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        dist = new long[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            edges.add(new Edge(start, end, weight));
        }

        StringBuilder sb = new StringBuilder();
        if (BellmanFord(n, m)) {
            for (int i = 2; i <= n; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    static boolean BellmanFord(int n, int m) {
        dist[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int start = edges.get(j).start;
                int end = edges.get(j).end;
                int weight = edges.get(j).weight;
                if (dist[start] != INF && dist[end] > dist[start] + weight) {
                    dist[end] = dist[start] + weight;
                    if (i == n) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}