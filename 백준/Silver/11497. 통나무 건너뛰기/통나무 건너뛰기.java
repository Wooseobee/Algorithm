import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.add(Integer.parseInt(st.nextToken()));
            }

            int[] tree = new int[n];
            int l = 0;
            int r = n - 1;
            int max = 0;
            boolean isLeft = true;
            while (!pq.isEmpty()) {
                int v = pq.poll();
                if (isLeft) {
                    tree[l++] = v;
                    isLeft = false;
                    if (l > 1) {
                        max = Math.max(max, tree[l - 1] - tree[l - 2]);
                        if (pq.isEmpty()) {
                            max = Math.max(max, tree[l - 1] - tree[l]);
                        }
                    }
                } else {
                    tree[r--] = v;
                    isLeft = true;
                    if (r < n - 2) {
                        max = Math.max(max, tree[r + 1] - tree[r + 2]);
                        if (pq.isEmpty()) {
                            max = Math.max(max, tree[r + 1] - tree[r]);
                        }
                    }
                }
            }
            max = Math.max(max, Math.abs(tree[0] - tree[n - 1]));
            sb.append(max).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}