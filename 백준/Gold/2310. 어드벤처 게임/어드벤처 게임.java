import java.io.*;
import java.util.*;

public class Main {

    private static class Maze {
        String alphabet;
        int cost;
        List<Integer> doors = new ArrayList<>();

        public Maze(String alphabet, int cost) {
            this.alphabet = alphabet;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            Maze[] maze = new Maze[n + 1];
            for (int i = 1; i <= n; i++) {
                String[] in = br.readLine().split(" ");
                maze[i] = new Maze(in[0], Integer.parseInt(in[1]));
                for (int j = 2; j < in.length - 1; j++) {
                    int nextDoor = Integer.parseInt(in[j]);
                    maze[i].doors.add(nextDoor);
                }
            }
            if (bfs(n, maze)) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean bfs(int n, Maze[] maze) {
        Queue<int[]> q = new LinkedList<>();
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        /*
        0: 현재 방 번호
        1: 현재 가진 돈
         */
        if (maze[1].alphabet.equals("T")) {
            return false;
        } else if (maze[1].alphabet.equals("L")) {
            q.add(new int[]{1, maze[1].cost});
            visited[1] = maze[1].cost;
        } else {
            q.add(new int[]{1, 0});
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int room = now[0];
            int money = now[1];

            if (room == n) {
                return true;
            }

            for (int next : maze[room].doors) {
                String nextAlphabet = maze[next].alphabet;
                switch (nextAlphabet) {
                    case "E":
                        if (money > visited[next]) {
                            visited[next] = money;
                            q.add(new int[]{next, money});
                        }
                        break;
                    case "L":
                        if (money > visited[next]) {
                            if (money < maze[next].cost) {
                                q.add(new int[]{next, maze[next].cost});
                            } else {
                                q.add(new int[]{next, money});
                            }
                            visited[next] = money;
                        }
                        break;
                    case "T":
                        if (money > visited[next]) {
                            if (money >= maze[next].cost) {
                                q.add(new int[]{next, money - maze[next].cost});
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }
}
