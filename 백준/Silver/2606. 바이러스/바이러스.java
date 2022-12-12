import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Node{
        int v;

        public Node(int v) {
            this.v = v;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static int cnt = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            graph.get(v).add(new Node(w));
            graph.get(w).add(new Node(v));
        }
        dfs(1);

        System.out.println(cnt);

        br.close();
    }

    static void dfs(int v) {
        visited[v] = true;
        for (Node node : graph.get(v)) {
            if (!visited[node.v]) {
                cnt++;
                dfs(node.v);
            }
        }
    }
}