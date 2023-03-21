import java.io.*;
import java.util.*;

public class Main {
    static int n, max = 0;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            board[i] = s.toCharArray();
        }

        countMaxCandy();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkCandy(i, j);
            }
        }

        System.out.println(max);
        br.close();
    }

    public static void checkCandy(int i, int j) {
        char candy = board[i][j];

        for (int k = 0; k < 4; k++) {
            int newI = i + dy[k];
            int newJ = j + dx[k];
            if (newI >= 0 && newJ >= 0 && newI < n && newJ < n) {
                if (board[newI][newJ] != candy) {
                    char tmp = board[i][j];
                    board[i][j] = board[newI][newJ];
                    board[newI][newJ] = tmp;
                    countMaxCandy();
                    board[newI][newJ] = board[i][j];
                    board[i][j] = tmp;
                }
            }

        }
    }

    public static void countMaxCandy() {
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            char candy = board[i][0];
            for (int j = 1; j < n; j++) {
                if (board[i][j] == candy) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    candy = board[i][j];
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            cnt = 1;
        }
        cnt = 1;
        for (int j = 0; j < n; j++) {
            char candy = board[0][j];
            for (int i = 1; i < n; i++) {
                if (board[i][j] == candy) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    candy = board[i][j];
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            cnt = 1;
        }
    }
}