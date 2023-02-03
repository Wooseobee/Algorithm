import java.io.*;
import java.util.*;

public class Main {
    static int n, k, min = Integer.MAX_VALUE;
    static int[] coins, values;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        coins = new int[n];
        values = new int[k + 1];
        visited = new boolean[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(values, 10_001);

        for (int j = 0; j < n; j++) {
            if (coins[j] <= k) bfs(coins[j]);
            Arrays.fill(visited, false);
        }

        if (values[k] == 10_001) {
            System.out.println(-1);
        } else {
            System.out.println(values[k]);
        }
        br.close();
    }

    static class Coin {
        int value;
        int count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static void bfs(int value) {
        Queue<Coin> q = new LinkedList<>();
        q.add(new Coin(value, 1));
        visited[value] = true;

        while (!q.isEmpty()) {
            Coin coin = q.poll();
            int v = coin.value;
            int c = coin.count;

            values[v] = Math.min(values[v], c);
            if (v == k) return;

            for (int i = 0; i < n; i++) {
                if (v + coins[i] <= k && !visited[v + coins[i]]) {
                    q.add(new Coin(v + coins[i], c + 1));
                    visited[v + coins[i]] = true;
                }
            }
        }
    }
}