import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            String[] vertex = br.readLine().split(" ");
            graph.get(Integer.parseInt(vertex[0])).add(Integer.parseInt(vertex[1]));
            graph.get(Integer.parseInt(vertex[1])).add(Integer.parseInt(vertex[0]));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(v);
        Arrays.fill(visited, false);
        System.out.println();
        BFS(v);
    }

    public static void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int value : graph.get(v)) {
            if (!visited[value]) {
                DFS(value);
            }
        }
    }

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int value : graph.get(v)) {
                if (!visited[value]) {
                    q.add(value);
                    visited[value] = true;
                }
            }
        }
    }
}