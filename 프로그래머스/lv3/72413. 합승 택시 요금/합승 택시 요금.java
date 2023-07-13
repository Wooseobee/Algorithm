import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 100_000 * n);
            dist[i][i] = 0;
        }
        for (int i = 0; i < fares.length; i++) {
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int cost = fares[i][2];
            dist[v1][v2] = cost;
            dist[v2][v1] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int total = 0;
            total += dist[s][i] + dist[i][a] + dist[i][b];
            answer = Math.min(answer, total);
        }
        return answer;
    }
}