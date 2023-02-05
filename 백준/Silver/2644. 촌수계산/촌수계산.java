import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int cnt = 1;
    static List<Integer>[] list;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            list[x].add(y);
            parent[y] = x;
        }

        if (isFamily(parent, a, b)) {
            findFamily(a, b, 0);
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
        br.close();
    }

    static void findFamily(int a, int b, int count) {
        if (a == b) {
            cnt = count;
            return;
        }
        if (visited[a]) {
            return;
        }

        visited[a] = true;
        for (int v : list[a]) {
            findFamily(v, b, count + 1);
        }

        findFamily(parent[a], b, count + 1);
    }

    static boolean isFamily(int[] parent, int a, int b) {
        int aParent = parent[a], bParent = parent[b];
        while (parent[a] != 0) {
            aParent = parent[a];
            a = aParent;
        }
        while (parent[b] != 0) {
            bParent = parent[b];
            b = bParent;
        }
        return a == b;
    }
}