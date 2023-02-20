import java.io.*;
import java.util.*;

public class Main {
    static class Bridge {
        int v;
        int w;

        public Bridge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static List<List<Bridge>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int max = 0;

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            list.get(v1).add(new Bridge(v2, w));
            list.get(v2).add(new Bridge(v1, w));
            max = Math.max(max, w);
        }

        input = br.readLine().split(" ");
        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (canGo(n, v1, v2, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l - 1);

        br.close();
    }

    private static boolean canGo(int n, int v1, int v2, int w) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        visited[v1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == v2) return true;
            for (Bridge b : list.get(now)) {
                if (!visited[b.v] && b.w >= w) {
                    q.add(b.v);
                    visited[b.v] = true;
                }
            }
        }

        return false;
    }
}