import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    private static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String[] in = br.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int m = Integer.parseInt(in[1]);
            Set<Integer> set = new HashSet<>();

            parent = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }
            for (int j = 0; j < m; j++) {
                in = br.readLine().split(" ");
                int x = Integer.parseInt(in[0]);
                int y = Integer.parseInt(in[1]);

                if (find(x) != find(y)) {
                    union(x, y);
                }
            }

            for (int j = 1; j <= n; j++) {
                find(j);
                set.add(parent[j]);
            }

            sb.append("#").append(i).append(" ").append(set.size()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = parent[x];
        y = parent[y];
        if (x != y) {
            parent[y] = x;
        }
    }
}