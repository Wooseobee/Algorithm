import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int n, m, min = Integer.MAX_VALUE;
    static int[] selectChicken;
    static int[][] city;
    static List<Point> home = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        city = new int[n + 1][n + 1];
        selectChicken = new int[m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    home.add(new Point(i, j));
                }
                if (city[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        select(0, 0);
        System.out.println(min);
        br.close();
    }

    static void select(int depth, int idx) {
        if (depth == m) {
            calculateDist();
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            selectChicken[depth] = i;
            select(depth + 1, i + 1);
        }
    }

    private static void calculateDist() {
        int dist = 0;
        for (Point h : home) {
            int minDist = Integer.MAX_VALUE;
            int homeX = h.j;
            int homeY = h.i;
            for (int i = 0; i < m; i++) {
                Point c = chicken.get(selectChicken[i]);
                int chickenX = c.j;
                int chickenY = c.i;
                minDist = Math.min(minDist, Math.abs(chickenX - homeX) + Math.abs(chickenY - homeY));
            }
            dist += minDist;
        }
        min = Math.min(min, dist);
    }
}