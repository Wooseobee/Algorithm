import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static double[][] star;
    static double[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        star = new double[n][2];
        parent = new int[n];
        graph = new double[(n - 1) * n / 2][3];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            star[i][0] = Double.parseDouble(st.nextToken());
            star[i][1] = Double.parseDouble(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = Math.sqrt(Math.pow(Math.abs(star[i][1] - star[j][1]), 2) + Math.pow(Math.abs(star[i][0] - star[j][0]), 2));
                graph[idx][0] = i;
                graph[idx][1] = j;
                graph[idx][2] = dist;
                idx++;
            }
        }

        Arrays.sort(graph, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[2] == o2[2]) {
                    return 0;
                } else if (o1[2] < o2[2]) {
                    return -1;
                }
                return 1;
            }
        });

        double total = 0;
        idx = 0;
        for (int i = 0; i < graph.length; i++) {
            if (idx == n - 1) break;
            if (find((int) graph[i][0]) != find((int) graph[i][1])) {
                idx++;
                total += graph[i][2];
                union((int) graph[i][0], (int) graph[i][1]);
            }
        }

        System.out.println((int) (total * 100) / 100.0);
        br.close();
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}