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
    static List<int[]> snake = new ArrayList<>();

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
        int tail = 0;
        int head = 0;
        boolean finish = false;
        snake.add(new int[]{1, 1});
        while (true) {
            time++;
            int x, y;
            switch (dir) {
                case '0': // 오른쪽
                    y = snake.get(head)[0];
                    x = snake.get(head)[1] + 1;

                    if (x > n || board[y][x] == 1) {
                        finish = true;
                        break;
                    }
                    snake.add(new int[]{y, x});
                    head++;
                    if (board[y][x] != -1) {
                        removeTail(tail);
                        head--;
                    }
                    board[y][x] = 1;
                    break;
                case '1': // 아래쪽
                    y = snake.get(head)[0] + 1;
                    x = snake.get(head)[1];

                    if (y > n || board[y][x] == 1) {
                        finish = true;
                        break;
                    }
                    snake.add(new int[]{y, x});
                    head++;
                    if (board[y][x] != -1) {
                        removeTail(tail);
                        head--;
                    }
                    board[y][x] = 1;
                    break;
                case '2': // 왼쪽
                    y = snake.get(head)[0];
                    x = snake.get(head)[1] - 1;

                    if (x < 1 || board[y][x] == 1) {
                        finish = true;
                        break;
                    }
                    snake.add(new int[]{y, x});
                    head++;
                    if (board[y][x] != -1) {
                        removeTail(tail);
                        head--;
                    }
                    board[y][x] = 1;
                    break;
                case '3': // 위쪽
                    y = snake.get(head)[0] - 1;
                    x = snake.get(head)[1];

                    if (y < 1 || board[y][x] == 1) {
                        finish = true;
                        break;
                    }
                    snake.add(new int[]{y, x});
                    head++;
                    if (board[y][x] != -1) {
                        removeTail(tail);
                        head--;
                    }
                    board[y][x] = 1;
                    break;
            }
            if (finish) {
                break;
            }
            dir = changeDir(dir, time);
        }

        System.out.println(time);
        br.close();
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

    private static void removeTail(int tail) {
        board[snake.get(tail)[0]][snake.get(tail)[1]] = 0;
        snake.remove(tail);
    }
}