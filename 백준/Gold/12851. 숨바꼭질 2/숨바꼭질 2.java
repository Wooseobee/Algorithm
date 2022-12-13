import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, k, total;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        visited = new boolean[100_001];

        bfs(n);

        System.out.println(min + "\n" + total);

        br.close();
    }

    static void bfs(int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, 0});

        while (!q.isEmpty()) {
            int[] nowArr = q.poll();
            int now = nowArr[0];
            int cnt = nowArr[1];
            visited[now] = true;
            if (cnt > min) {
                continue;
            }
            if (now < k) {
                if (now * 2 <= 100_000 && !visited[now * 2]) {
                    q.add(new int[]{now * 2, cnt + 1});
                }
                if (now + 1 <= 100_000 && !visited[now + 1]) {
                    q.add(new int[]{now + 1, cnt + 1});
                }
            }
            if (now - 1 >= 0 && !visited[now - 1]) {
                q.add(new int[]{now - 1, cnt + 1});
            }
            if (now == k) {
                if (min > cnt) {
                    min = cnt;
                    total = 1;
                } else if (min == cnt) {
                    total++;
                }
            }
        }
    }
}