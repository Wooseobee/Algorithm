import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int f, s, g, u, d, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        f = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        g = Integer.parseInt(input[2]);
        u = Integer.parseInt(input[3]);
        d = Integer.parseInt(input[4]);

        if (bfs()) {
            System.out.println(cnt);
        } else {
            System.out.println("use the stairs");
        }
        br.close();
    }

    static class Elevator {
        int stair;
        int count;

        public Elevator(int stair, int count) {
            this.stair = stair;
            this.count = count;
        }
    }

    static boolean bfs() {
        Queue<Elevator> q = new LinkedList<>();
        q.add(new Elevator(s, 0));
        boolean visited[] = new boolean[1_000_001];

        while (!q.isEmpty()) {
            Elevator now = q.poll();
            int stair = now.stair;
            int count = now.count;

            if (stair == g) {
                cnt = count;
                return true;
            }

            if (visited[stair]) continue;
            visited[stair] = true;

            if (stair + u <= f && u != 0) {
                q.add(new Elevator(stair + u, count + 1));
            }
            if (stair - d >= 1 && d != 0) {
                q.add(new Elevator(stair - d, count + 1));
            }
        }
        return false;
    }
}