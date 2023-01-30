import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Index {
        int index;
        int time;

        public Index(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        System.out.println(bfs(n, k));
        br.close();
    }

    static int bfs(int idx, int k) {
        Queue<Index> q = new LinkedList<>();
        boolean[] visited = new boolean[100_001];
        q.add(new Index(idx, 0));
        int cnt = 0;

        while (!q.isEmpty()) {
            Index index = q.poll();
            int next = index.index;
            int time = index.time;

            if (next == k) {
                cnt = time;
                break;
            }

            if (visited[next]) continue;

            visited[next] = true;

            if (next > 0 && !visited[next - 1]) {
                q.add(new Index(next - 1, time + 1));
            }
            if (next < k) {
                if (next * 2 <= 100_000 && !visited[next * 2]) {
                    q.add(new Index(next * 2, time + 1));
                }
                if (next + 1 <= 100_000 && !visited[next + 1]) {
                    q.add(new Index(next + 1, time + 1));
                }
            }
        }

        return cnt;
    }
}