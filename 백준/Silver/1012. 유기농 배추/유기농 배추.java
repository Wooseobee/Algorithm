import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int n, m, k;
    static int[] newX = {-1, 1, 0, 0};
    static int[] newY = {0, 0, -1, 1};
    static int[][] field = new int[51][51];
    static boolean[][] visited = new boolean[51][51];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            for (boolean[] v : visited) {
                Arrays.fill(v, false);
            }
            for (int[] f : field) {
                Arrays.fill(f, 0);
            }

            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            Count(k);

        }
    }

    static void Count(int k) throws IOException {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            field[y][x] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        if (visited[x][y] == true) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            if (x + newX[i] >= 0 && x + newX[i] < n) {
                if (field[x + newX[i]][y] == 1) {
                    dfs(x + newX[i], y);
                }
            }
            if (y + newY[i] >= 0 && y + newY[i] < m) {
                if (field[x][y + newY[i]] == 1) {
                    dfs(x, y + newY[i]);
                }
            }
        }
    }
}