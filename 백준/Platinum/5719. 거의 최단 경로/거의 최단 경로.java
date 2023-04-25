import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int n,m,s,d;
    static int u,v,p;
    static int[] dist;
    static boolean[][] edges;
    static List<Node>[] city;
    static List<Integer>[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            dist = new int[n];
            edges = new boolean[n][n];
            city = new List[n];
            prev = new List[n];
            for (int i = 0; i < n; i++) {
                city[i] = new ArrayList<>();
                prev[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                city[u].add(new Node(v, p));
            }

            dijkstra();
            removeEdges();
            dijkstra();

            if (dist[d] == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[d]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void removeEdges() {
        Queue<Integer> q = new LinkedList<>();
        q.add(d);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int prevVertex : prev[now]) {
                if (!edges[prevVertex][now]) {
                    edges[prevVertex][now] = true;
                    q.add(prevVertex);
                }
            }
        }
    }

    private static void dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        dist[s] = 0;
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.v] < now.w) continue;

            for (Node next : city[now.v]) {
                if (!edges[now.v][next.v]) {
                    if (dist[next.v] > dist[now.v] + next.w) {
                        dist[next.v] = dist[now.v] + next.w;
                        pq.add(new Node(next.v, dist[next.v]));
                        prev[next.v].clear();
                        prev[next.v].add(now.v);
                    } else if (dist[next.v] == dist[now.v] + next.w) {
                        prev[next.v].add(now.v);
                    }
                }
            }
        }
    }
}