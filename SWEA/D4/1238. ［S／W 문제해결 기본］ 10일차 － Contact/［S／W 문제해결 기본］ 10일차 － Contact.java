import java.io.*;
import java.util.*;

public class Solution {

    private static List[] contact;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            String[] in = br.readLine().split(" ");
            int l = Integer.parseInt(in[0]);
            int s = Integer.parseInt(in[1]);

            contact = new ArrayList[101];
            for (int j = 1; j <= 100; j++) {
                contact[j] = new ArrayList<>();
            }

            in = br.readLine().split(" ");
            for (int j = 0; j < l; j += 2) {
                int from = Integer.parseInt(in[j]);
                int to = Integer.parseInt(in[j + 1]);
                contact[from].add(to);
            }

            Queue<int[]> q = new ArrayDeque<int[]>();
            boolean[] visited = new boolean[101];
            List<Integer> depthList = new ArrayList<>();
            q.add(new int[]{s, 1});
            depthList.add(s);

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int idx = now[0];
                int depth = now[1];

                if (visited[idx]) {
                    continue;
                }
                visited[idx] = true;

                if (depthList.size() < depth) {
                    depthList.add(idx);
                } else {
                    int nowDepthMax = depthList.get(depth - 1);
                    depthList.set(depth - 1, Math.max(nowDepthMax, idx));
                }

                for (int next : (ArrayList<Integer>) contact[idx]) {
                    if (!visited[next]) {
                        q.add(new int[]{next, depth + 1});
                    }
                }
            }

            sb.append("#").append(i).append(" ").append(depthList.get(depthList.size() - 1)).append("\n");
        }
        System.out.println(sb);
        br.close();

    }

}