
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> ans = bfs(n);

        StringBuilder sb = new StringBuilder();
        if (ans != null) {
            sb.append(ans.size() - 1).append("\n");
            for (int v : ans) {
                sb.append(v).append(" ");
            }
            System.out.println(sb);
        }
        br.close();
    }

    static class Value {
        int v;
        List<Integer> answer;

        public Value(int v, List<Integer> answer) {
            this.v = v;
            this.answer = answer;
        }
    }

    private static List<Integer> bfs(int n) {
        Queue<Value> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        list.add(n);
        visited[n] = true;
        q.add(new Value(n, list));

        while (!q.isEmpty()) {
            Value V = q.poll();
            int now = V.v;
            if (now == 1) {
                return V.answer;
            }
            if (now % 3 == 0 && !visited[now / 3]) {
                List<Integer> ans = new ArrayList<>(List.copyOf(V.answer));
                ans.add(now / 3);
                visited[now / 3] = true;
                q.add(new Value(now / 3, ans));
            }
            if (now % 2 == 0 && !visited[now / 2]) {
                List<Integer> ans = new ArrayList<>(List.copyOf(V.answer));
                ans.add(now / 2);
                visited[now / 2] = true;
                q.add(new Value(now / 2, ans));
            }
            if (!visited[now - 1]) {
                List<Integer> ans = new ArrayList<>(List.copyOf(V.answer));
                ans.add(now - 1);
                visited[now - 1] = true;
                q.add(new Value(now - 1, ans));
            }
        }
        return null;
    }
}