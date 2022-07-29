import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//DFS or BFS
public class Main {
    static boolean[] visit;
    static int[] parent;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        visit = new boolean[N + 1];
        parent = new int[N + 1];


        for (int i = 0; i < N - 1; i++) {
            String s[] = br.readLine().split(" ");

            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            list[x].add(y);
            list[y].add(x);
        }
//        dfs(1);
        bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    //    public static void dfs(int v) {
//        visit[v] = true;
//
//        for (int i : list[v]) {
//            if (!visit[i]) {
//                parent[i]=v;
//                dfs(i);
//            }
//        }
//    }
    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for (int item : list[p]) {
                if (visit[item]==false) {
                    visit[item] = true;
                    parent[item] = p;
                    queue.offer(item);
                }
            }
        }
    }
}