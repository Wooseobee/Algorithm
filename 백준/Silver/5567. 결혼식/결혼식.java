import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> friends[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        friends = new List[n + 1];

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int f1 = Integer.parseInt(input[0]);
            int f2 = Integer.parseInt(input[1]);
            friends[f1].add(f2);
            friends[f2].add(f1);
        }

        bfs(1, n);

        System.out.println(cnt);
        br.close();
    }

    static void bfs(int idx, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        boolean[] isIdxFriend = new boolean[n + 1];

        visited[idx] = true;
        for (int friend : friends[idx]) {
            q.add(friend);
            isIdxFriend[friend] = true;
        }

        while (!q.isEmpty()) {
            int anotherFriend = q.poll();

            if (!visited[anotherFriend]) {
                if (isIdxFriend[anotherFriend]) {
                    for (int friend : friends[anotherFriend]) {
                        q.add(friend);
                    }
                }
                visited[anotherFriend] = true;
                cnt++;
            }
        }
    }
}