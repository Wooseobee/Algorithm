import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int i;
        int j;
        int cnt;
        int maxGasSize;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Point(int i, int j, int cnt, int maxGasSize) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.maxGasSize = maxGasSize;
        }
    }

    static int n, k;
    static int[] dp;
    static List<Point> stop = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stop.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        int min = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();
            int i = now.i;
            int j = now.j;
            int cnt = now.cnt;
            int maxGasSize = now.maxGasSize;

            if (cnt < k) {
                for (int l = 0; l < stop.size(); l++) {
                    Point next = stop.get(l);
                    int nextI = next.i;
                    int nextJ = next.j;
                    int needGasSize = calGasSize(i, j, nextI, nextJ);

                    int max = Math.max(maxGasSize, needGasSize);
                    if (dp[l] > max) {
                        int needGasSizeToDestination = calGasSize(nextI, nextJ, 10_000, 10_000);
                        q.add(new Point(next.i, next.j, cnt + 1, max));
                        dp[l] = max;
                        min = Math.min(min, Math.max(max, needGasSizeToDestination));
                    }
                }
            }
        }
        return min;
    }

    private static int calGasSize(int i, int j, int nextI, int nextJ) {
        return (int) Math.ceil(Math.sqrt(Math.pow(i - nextI, 2) + Math.pow(j - nextJ, 2)) / 10.0);
    }
}