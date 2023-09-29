import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n;
    private static int[] s, e;
    private static boolean[] visited;
    private static List<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < t; test_case++) {
            n = Integer.parseInt(br.readLine());
            String[] in = br.readLine().split(" ");
            s = new int[2];
            e = new int[2];
            visited = new boolean[n];
            s[0] = Integer.parseInt(in[0]);
            s[1] = Integer.parseInt(in[1]);
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                in = br.readLine().split(" ");
                list.add(new int[]{Integer.parseInt(in[0]), Integer.parseInt(in[1])});
            }
            in = br.readLine().split(" ");
            e[0] = Integer.parseInt(in[0]);
            e[1] = Integer.parseInt(in[1]);

            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Math.abs(s[0] - o1[0]) + Math.abs(s[1] - o1[1]) - (Math.abs(s[0] - o2[0]) + Math.abs(s[1] - o2[1]));
                }
            });
            if (canGo()) sb.append("happy").append("\n");
            else sb.append("sad").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean canGo() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s[0], s[1], -1});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            int idx = now[2];

            if (idx != -1) {
                if (visited[idx]) continue;
                visited[idx] = true;
            }

            if (Math.abs(i - e[0]) + Math.abs(j - e[1]) <= 1_000) return true;

            for (int k = 0; k < n; k++) {
                int nI = list.get(k)[0];
                int nJ = list.get(k)[1];
                int dist = Math.abs(i - nI) + Math.abs(j - nJ);
                if (!visited[k] && dist <= 1_000) {
                    q.add(new int[]{nI, nJ, k});
                }
            }
        }
        return false;

    }
}