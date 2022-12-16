import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] visited, finish;
    static int[] choice;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            cnt = 0;
            String[] s = br.readLine().split(" ");
            visited = new boolean[n + 1];
            finish = new boolean[n + 1];
            choice = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                choice[j] = Integer.parseInt(s[j - 1]);
            }
            for (int j = 1; j <= n; j++) {
                dfs(j);
            }
            System.out.println(n - cnt);
        }
    }

    static void dfs(int now) {
        if (visited[now]) {
            finish[now] = true;
            cnt++;
        }

        visited[now] = true;
        int next = choice[now];

        if (!finish[next]) {
            dfs(next);
        }

        visited[now] = false;
        finish[now] = true;
    }
}