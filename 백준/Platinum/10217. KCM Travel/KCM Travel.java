import java.io.*;
import java.util.*;

public class Main {
    static class Ticket {
        int v;
        int c;
        int d;

        public Ticket(int v, int c, int d) {
            this.v = v;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][m + 1];
            List<Ticket>[] tickets = new List[n + 1];

            for (int j = 1; j <= n; j++) {
                tickets[j] = new ArrayList<>();
                Arrays.fill(dp[j], Integer.MAX_VALUE);
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                tickets[u].add(new Ticket(v, c, d));
            }

            PriorityQueue<Ticket> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
            pq.add(new Ticket(1, 0, 0));
            dp[1][0] = 0;
            int ans = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                Ticket now = pq.poll();

                if (now.v == n) {
                    ans = now.d;
                    break;
                }

                for (Ticket ticket : tickets[now.v]) {
                    int nextCost = now.c + ticket.c;
                    int nextDist = now.d + ticket.d;
                    if (nextCost > m) continue;
                    if (nextDist >= dp[ticket.v][nextCost]) continue;

                    if (dp[ticket.v][now.c + ticket.c] > now.d + ticket.d) {
                        dp[ticket.v][now.c + ticket.c] = now.d + ticket.d;
                        for (int j = nextCost; j <= m; j++) {
                            if (dp[ticket.v][j] > nextDist) {
                                dp[ticket.v][j] = nextDist;
                            }
                        }
                        pq.add(new Ticket(ticket.v, now.c + ticket.c, dp[ticket.v][now.c + ticket.c]));
                    }
                }
            }
            if (ans == Integer.MAX_VALUE) {
                sb.append("Poor KCM").append("\n");
            } else {
                sb.append(ans).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}