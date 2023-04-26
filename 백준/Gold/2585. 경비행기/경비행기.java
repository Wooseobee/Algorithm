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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        List<Point> stop = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stop.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 0));

        int min = Integer.MAX_VALUE;
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
                    int needGasSize = (int) Math.ceil(Math.sqrt(Math.pow(i - nextI, 2) + Math.pow(j - nextJ, 2)) / 10.0);

                    int max = Math.max(maxGasSize, needGasSize);
                    if (dp[l] > max) {
                        int needGasSizeToDestination = (int) Math.ceil(Math.sqrt(Math.pow(nextI - 10_000, 2) + Math.pow(nextJ - 10_000, 2)) / 10.0);
                        q.add(new Point(next.i, next.j, cnt + 1, max));
                        dp[l] = max;
                        min = Math.min(min, Math.max(max, needGasSizeToDestination));
                    }
                }
            }
        }

        System.out.println(min);
        br.close();
    }
}