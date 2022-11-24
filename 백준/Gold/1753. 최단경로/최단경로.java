import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int idx;
    int cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);

        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[x] = 0;

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            graph.get(v).add(new Node(w, cost));
        }

        Dijkstra(n, x);

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void Dijkstra(int n, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().idx;

            if (!visited[now]) {
                visited[now] = true;
            }

            for (Node next : graph.get(now)) {
                if (dist[next.idx] > dist[now] + next.cost) {
                    dist[next.idx] = dist[now] + next.cost;

                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}