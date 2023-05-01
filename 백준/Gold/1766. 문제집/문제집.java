import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] problem = new List[n + 1];
        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            problem[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            problem[p1].add(p2);
            inDegree[p2]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int now = pq.poll();

            sb.append(now).append(" ");
            for (int next : problem[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}