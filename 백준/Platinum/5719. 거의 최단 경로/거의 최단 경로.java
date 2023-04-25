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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            List<Node>[] city = new List[n];
            for (int i = 0; i < n; i++) {
                city[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                city[u].add(new Node(v, p));
            }
            int[] dist = new int[n];
            boolean[][] edges = new boolean[n][n];
            List<Integer>[] prev = new List[n];

            Arrays.fill(dist, Integer.MAX_VALUE);
            for (int i = 0; i < prev.length; i++) {
                prev[i] = new ArrayList<>();
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
            dist[s] = 0;
            pq.add(new Node(s, 0));

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (dist[now.v] < now.w) continue;

                for (Node next : city[now.v]) {
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
            Queue<Integer> q = new LinkedList<>();
            q.add(d);
            boolean[] visited = new boolean[n];

            while (!q.isEmpty()) {
                int now = q.poll();
                for (int prevVertex : prev[now]) {
                    if (!edges[prevVertex][now]) {
                        edges[prevVertex][now] = true;
                        q.add(prevVertex);
                    }
                }
            }

            PriorityQueue<Node> pq2 = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
            pq2.add(new Node(s, 0));
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(visited, false);
            dist[s] = 0;
            while (!pq2.isEmpty()) {
                Node now = pq2.poll();
                if (visited[now.v]) continue;
                visited[now.v] = true;

                for (Node next : city[now.v]) {
                    if (!edges[now.v][next.v] && dist[next.v] > dist[now.v] + next.w) {
                        dist[next.v] = dist[now.v] + next.w;
                        pq2.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
            if (dist[d] == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(dist[d]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}