import java.util.*;
import java.io.*;

class Solution {
    private static int cnt;
    private static int[] in, out;
    private static List[] students;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            in = new int[n + 1];
            out = new int[n + 1];
            students = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                students[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < m; i++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                students[a].add(b);
            }

            for (int i = 1; i <= n; i++) {
                cnt = 0;
                dfs(i, new boolean[n + 1]);
                out[i] = cnt;
            }

            int total = 0;
            for (int i = 1; i <= n; i++) {
                if (in[i] + out[i] == n - 1) total++;
            }

            sb.append("#").append(test_case).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void dfs(int i, boolean[] visited) {
        for (int j = 0; j < students[i].size(); j++) {
            int next = (int) students[i].get(j);
            if (!visited[next]) {
                in[next]++;
                visited[next] = true;
                dfs(next, visited);
                cnt++;
            }
        }
    }
}