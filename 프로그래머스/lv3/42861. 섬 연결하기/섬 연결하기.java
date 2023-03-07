import java.util.*;

class Solution {
    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] visited = new boolean[n];
        List<List<Edge>> graph = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < costs.length; i++) {
            int v1 = costs[i][0];
            int v2 = costs[i][1];
            int w = costs[i][2];

            graph.get(v1).add(new Edge(v2, w));
            graph.get(v2).add(new Edge(v1, w));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int v = now.v;
            int w = now.w;

            if (visited[v]) continue;
            answer += w;
            visited[v] = true;

            for (Edge e : graph.get(v)) {
                if (!visited[e.v]) {
                    pq.add(e);
                }
            }
        }

        return answer;
    }
}