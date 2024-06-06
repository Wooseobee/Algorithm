import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static List<Road>[] area;

    private static class Road {
        int dist;
        int startTime;

        private Road(int dist, int startTime) {
            this.dist = dist;
            this.startTime = startTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        area = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            area[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);

            area[a].add(new Road(b, i));
            area[b].add(new Road(a, i));
        }

        System.out.println(findWay());
        br.close();
    }

    private static long findWay() {
        // [시간, 지역]
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[0], o2[0]));
        long[] timeToReach = new long[n + 1];
        Arrays.fill(timeToReach, Long.MAX_VALUE);
        timeToReach[1] = 0;
        pq.add(new long[]{0, 1});

        while (!pq.isEmpty()) {
            long[] now = pq.poll();
            long nowTime = now[0];
            int nowArea = (int) now[1];

            if (nowTime > timeToReach[nowArea]) {
                continue;
            }

            if (nowArea == n) {
                return nowTime;
            }

            for (int i = 0; i < area[nowArea].size(); i++) {
                Road road = area[nowArea].get(i);
                int next = road.dist;
                int startTime = road.startTime;

                long waitTime = (m - ((nowTime - startTime) % m)) % m;
                long nextTime = nowTime + waitTime + 1;
                if (nextTime < timeToReach[next]) {
                    timeToReach[next] = nextTime;
                    pq.add(new long[]{nextTime, next});
                }

            }
        }

        return 0;
    }

}
