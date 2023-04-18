import java.io.*;
import java.util.*;

public class Main {
    static int r, c, max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] alphabet = new boolean[26];
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                board[i][j] = input[j].charAt(0);
            }
        }

        alphabet[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
        br.close();
    }

    private static void dfs(int i, int j, int depth) {
        if (depth == 26) {
            max = 26;
            return;
        }
        max = Math.max(max, depth);
        for (int k = 0; k < 4; k++) {
            int newI = i + dy[k];
            int newJ = j + dx[k];
            if (newI >= 0 && newJ >= 0 && newI < r && newJ < c) {
                int alphabetIndex = board[newI][newJ] - 'A';
                if (!alphabet[alphabetIndex]) {
                    alphabet[alphabetIndex] = true;

                    dfs(newI, newJ, depth + 1);

                    alphabet[alphabetIndex] = false;
                }
            }
        }
    }
}