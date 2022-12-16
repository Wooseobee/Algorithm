import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Line {
        int start;
        int end;
        int w;

        public Line(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }

    static List<Line> list = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            list.add(new Line(a, b, c));
        }

        Collections.sort(list, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.w - o2.w;
            }
        });

        int sum = 0;
        for (int i = 0; i < m; i++) {
            Line line = list.get(i);
            if (find(line.start) != find(line.end)) {
                sum += line.w;
                union(line.start, line.end);
            }
        }

        System.out.println(sum);

        br.close();
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
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