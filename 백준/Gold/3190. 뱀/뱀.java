import java.io.*;
import java.util.*;

public class Main {
    static class Dir {
        int time;
        char dir;

        public Dir(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static int n, k, l;
    static int[][] board;
    static List<Dir> list = new ArrayList<>();
    static Deque<int[]> snake = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n + 1][n + 1];

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Dir(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        int time = 0;
        char dir = '0';
        snake.add(new int[]{1, 1});
        while (true) {
            time++;
            int[] head = snake.getFirst();
            int y = head[0];
            int x = head[1];
            switch (dir) {
                case '0': // 오른쪽
                    x++;
                    break;
                case '1': // 아래쪽
                    y++;
                    break;
                case '2': // 왼쪽
                    x--;
                    break;
                case '3': // 위쪽
                    y--;
                    break;
            }
            if (checkFinish(y, x)) {
                break;
            }
            dir = changeDir(dir, time);
        }

        System.out.println(time);
        br.close();
    }

    private static boolean checkFinish(int y, int x) {
        if (x < 1 || y < 1 || x > n || y > n || board[y][x] == 1) {
            return true;
        }
        snake.addFirst(new int[]{y, x});
        if (board[y][x] != -1) {
            removeTail(snake.getLast());
        }
        board[y][x] = 1;
        return false;
    }

    private static char changeDir(char dir, int time) {
        if (!list.isEmpty()) {
            Dir d = list.get(0);
            if (d.time == time) {
                list.remove(0);
                switch (d.dir) {
                    case 'D':
                        if (dir == '0') {
                            return '1';
                        } else if (dir == '1') {
                            return '2';
                        } else if (dir == '2') {
                            return '3';
                        } else {
                            return '0';
                        }
                    case 'L':
                        if (dir == '0') {
                            return '3';
                        } else if (dir == '1') {
                            return '0';
                        } else if (dir == '2') {
                            return '1';
                        } else {
                            return '2';
                        }
                }
            }
        }
        return dir;
    }

    private static void removeTail(int[] tail) {
        board[tail[0]][tail[1]] = 0;
        snake.removeLast();
    }
}