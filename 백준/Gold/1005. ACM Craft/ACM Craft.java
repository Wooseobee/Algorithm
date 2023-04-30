import java.io.*;
import java.util.*;

public class Main {
    static class Order{
        int buildingNum;
        int duration;

        public Order(int buildingNum, int duration) {
            this.buildingNum = buildingNum;
            this.duration = duration;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] building = new int[n + 1];
            int[] inDegree = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                building[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] rules = new List[n + 1];
            for (int j = 1; j <= n; j++) {
                rules[j] = new ArrayList<>();
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int b1 = Integer.parseInt(st.nextToken());
                int b2 = Integer.parseInt(st.nextToken());
                rules[b1].add(b2);
                inDegree[b2]++;
            }

            int w = Integer.parseInt(br.readLine());

            int[] maxCost = new int[n + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j <= n; j++) {
                if (inDegree[j] == 0) {
                    q.add(j);
                    maxCost[j] = building[j];
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : rules[now]) {
                    inDegree[next]--;
                    maxCost[next] = Math.max(maxCost[next], maxCost[now] + building[next]);
                    if (inDegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
            sb.append(maxCost[w]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}