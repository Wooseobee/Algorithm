import java.io.*;
import java.util.*;

public class Main {
    static int n, answerX, answerY, cnt;
    static boolean found = false;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = 20;
        map = new int[n][n];
        visited = new boolean[n][n][8];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] != 0) {
                    findDirection(i, j);
                }
            }
            if (found) break;
        }
        if (found) {
            System.out.println(map[answerY][answerX] + "\n" + answerY + " " + answerX);
        } else {
            System.out.println(0);
        }
    }

    private static void findDirection(int i, int j) {
        int color = map[i][j];
        for (int k = 0; k < 8; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                if (color == map[y][x] && !visited[y][x][k]) {
                    cnt = 0;
                    checkWinner(i, j, k);

                    if (cnt == 5) {
                        if (k == 2) {
                            answerY = i + 4;
                            answerX = j - 4;
                        } else {
                            answerY = i;
                            answerX = j;
                        }
                        found = true;
                        break;
                    }
                }
            }
        }
    }

    private static void checkWinner(int i, int j, int direction) {
        int color = map[i][j];
        visited[i][j][direction] = true;
        cnt++;
        for (int k = 0; k < 8; k++) {
            int y = i + dy[k];
            int x = j + dx[k];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                if (color == map[y][x] && !visited[y][x][k] && k == direction) {
                    checkWinner(y, x, direction);
                }
            }
        }
    }
}