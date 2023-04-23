import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];
        tree = new long[n * 4];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                arr[b] = c;
                update(1, n, 1, b, c);
            } else if (a == 2) {
                sb.append(multiple(1, n, 1, b, (int) c)).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1) % 1_000_000_007;
    }

    private static long multiple(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right) % 1_000_000_007;
    }

    private static long update(int start, int end, int node, int idx, long val) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) return tree[node] = val;
        int mid = (start + end) / 2;
        return tree[node] = update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val) % 1_000_000_007;
    }
}