import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100_001];
    static int[] parent = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        bfs(n);

        System.out.println(min);

        Stack<Integer> stack = new Stack<>();

        int idx = k;

        while (idx != n) {
            stack.push(idx);
            idx = parent[idx];
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        br.close();
    }

    static void bfs(int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});

        while (!q.isEmpty()) {
            int[] nowArr = q.poll();
            int now = nowArr[0];
            int cnt = nowArr[1];
            if (cnt > min) {
                continue;
            }
            if (now * 2 <= 100_000 && !visited[now * 2]) {
                q.add(new int[]{now * 2, cnt + 1});
                visited[now * 2] = true;
                parent[now * 2] = now;
            }
            if (now + 1 <= 100_000 && !visited[now + 1]) {
                q.add(new int[]{now + 1, cnt + 1});
                visited[now + 1] = true;
                parent[now + 1] = now;
            }
            if (now - 1 >= 0 && !visited[now - 1]) {
                q.add(new int[]{now - 1, cnt + 1});
                visited[now - 1] = true;
                parent[now - 1] = now;
            }
            if (now == k) {
                if (min > cnt) {
                    min = cnt;
                }
            }
        }
    }
}