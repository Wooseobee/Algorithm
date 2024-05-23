import java.io.*;
import java.util.*;

public class Main {

    private static int min = Integer.MAX_VALUE;

    private static class Road {
        int dist;
        int cost;

        public Road(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        List<int[]>[] map = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            map[a].add(new int[]{a, b, c});
            map[b].add(new int[]{b, a, c});
        }

        findWay(n, m, map);

        System.out.println(min);
        br.close();
    }

    private static void findWay(int n, int m, List<int[]>[] map) {
        PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < map[1].size(); i++) {
            int[] start = map[1].get(i);
            pq.add(new Road(start[1], start[2]));
        }

        while (!pq.isEmpty()) {
            Road now = pq.poll();
            int cost = now.cost;
            int a = now.dist;
            visited[a] = true;

            if (a == n) {
                min = cost;
                break;
            }

            for (int i = 0; i < map[a].size(); i++) {
                int[] next = map[a].get(i);
                int dist = next[1];
                int nextCost = next[2];
                if (!visited[next[1]]) {
                    pq.add(new Road(dist, cost + nextCost));
                }
            }

        }
    }
}