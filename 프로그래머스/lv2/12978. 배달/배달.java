import java.util.*;

class Solution {
    static class Road {
        int v;
        int w;

        public Road(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int[] dist;
    static boolean[] visited;
    static List<Road>[] village;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        village = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            village[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int[] roadInfo : road) {
            int v1 = roadInfo[0];
            int v2 = roadInfo[1];
            int w = roadInfo[2];

            village[v1].add(new Road(v2, w));
            village[v2].add(new Road(v1, w));
        }

        dijkstra();

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }

    private static void dijkstra() {
        PriorityQueue<Road> pq = new PriorityQueue<>((r1, r2) -> r1.w - r2.w);
        pq.add(new Road(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Road now = pq.poll();
            if (visited[now.v]) continue;
            visited[now.v] = true;

            for (Road next : village[now.v]) {
                if (dist[next.v] > now.w + next.w) {
                    dist[next.v] = now.w + next.w;
                    pq.add(new Road(next.v, dist[next.v]));
                }
            }
        }
    }
}