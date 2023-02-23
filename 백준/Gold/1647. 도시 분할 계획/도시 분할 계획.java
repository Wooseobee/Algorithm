import java.util.*;
import java.io.*;

public class Main {
    static class Road {
        int v1;
        int v2;
        int w;

        public Road(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    static List<Road> list = new ArrayList<>();
    static int n, m, lastWeight;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            list.add(new Road(v1, v2, w));
        }

        Collections.sort(list, ((o1, o2) -> o1.w - o2.w));

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        System.out.println(kruskal() - lastWeight);
        br.close();
    }

    static int kruskal() {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            Road r = list.get(i);
            if (find(r.v1) != find(r.v2)) {
                sum += r.w;
                union(r.v1, r.v2);
                lastWeight = r.w;
            }
        }
        return sum;
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }
}