import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node {
    int v;
    int cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        String[] s;

        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            list.get(Integer.parseInt(s[0])).add(new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        }

        s = br.readLine().split(" ");
        dist[Integer.parseInt(s[0])] = 0;

        dijkstra(Integer.parseInt(s[0]));

        System.out.println(dist[Integer.parseInt(s[1])]);

        br.close();
    }

    public static void dijkstra(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(v, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().v;

            if (!visited[now]) {
                visited[now] = true;
                for (Node next : list.get(now)) {
                    if (dist[next.v] > dist[now] + next.cost) {
                        dist[next.v] = dist[now] + next.cost;

                        pq.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
    }
}