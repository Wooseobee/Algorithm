import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {

    static List<List<Node>> graph = new ArrayList<>();
    static boolean[][] visited;
    static int[][] dist;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1][n + 1];
        dist = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            for (int j = 1; j < n + 1; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if (i == j) {
                    dist[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(v).add(new Node(w, cost));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        for (int i = 1; i < n+1; i++) {
            if (max < dist[i][x] + dist[x][i]) {
                max = dist[i][x] + dist[x][i];
            }
        }
        System.out.println(max);
    }

    public static void dijkstra(int vertex) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(vertex, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().v;

            if (!visited[vertex][now]) {
                visited[vertex][now] = true;
            }

            for (Node next : graph.get(now)) {
                if (dist[vertex][next.v] > dist[vertex][now] + next.cost) {
                    dist[vertex][next.v] = dist[vertex][now] + next.cost;

                    pq.add(new Node(next.v, dist[vertex][next.v]));
                }
            }
        }
    }
}