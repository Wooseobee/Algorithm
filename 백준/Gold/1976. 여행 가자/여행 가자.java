import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static List<Integer>[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cities = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            cities[i] = new ArrayList<>();
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(in[j]);
                if (a == 1) {
                    cities[i].add(j + 1);
                }
            }
        }

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < m - 1; i++) {
            int now = Integer.parseInt(in[i]);
            int next = Integer.parseInt(in[i + 1]);

            if (!canVisit(next, now)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
        br.close();
    }

    private static boolean canVisit(int end, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end) {
                return true;
            }

            for (int i = 0; i < cities[now].size(); i++) {
                int next = cities[now].get(i);

                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
}
