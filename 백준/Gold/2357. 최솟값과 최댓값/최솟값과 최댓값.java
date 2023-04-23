import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        minTree = new int[n * 4];
        maxTree = new int[n * 4];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        minInit(1, n, 1);
        maxInit(1, n, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(minFind(1, n, 1, a, b)).append(" ").append(maxFind(1, n, 1, a, b)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int minInit(int s, int e, int node) {
        if (s == e) return minTree[node] = arr[s];
        int mid = (s + e) / 2;
        return minTree[node] = Math.min(minInit(s, mid, node * 2), minInit(mid + 1, e, node * 2 + 1));
    }

    private static int maxInit(int s, int e, int node) {
        if (s == e) return maxTree[node] = arr[s];
        int mid = (s + e) / 2;
        return maxTree[node] = Math.max(maxInit(s, mid, node * 2), maxInit(mid + 1, e, node * 2 + 1));
    }

    private static int minFind(int s, int e, int node, int l, int r) {
        if (r < s || e < l) return Integer.MAX_VALUE;
        if (l <= s && e <= r) return minTree[node];
        int mid = (s + e) / 2;
        return Math.min(minFind(s, mid, node * 2, l, r), minFind(mid + 1, e, node * 2 + 1, l, r));
    }

    private static int maxFind(int s, int e, int node, int l, int r) {
        if (r < s || e < l) return 0;
        if (l <= s && e <= r) return maxTree[node];
        int mid = (s + e) / 2;
        return Math.max(maxFind(s, mid, node * 2, l, r), maxFind(mid + 1, e, node * 2 + 1, l, r));
    }
}