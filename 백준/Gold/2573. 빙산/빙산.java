import java.io.*;
import java.util.*;

public class Main {
    static int n, m, year = 0, moveCnt;
    static int[][] ice;
    static int[][] newIce;
    static boolean[][] visited;
    static int iceCount = 0, newIceCount = 0;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        ice = new int[n][m];
        newIce = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ice[i][j] = Integer.parseInt(input[j]);
                newIce[i][j] = ice[i][j];
                if (ice[i][j] != 0) {
                    iceCount++;
                    newIceCount++;
                }
            }
        }

        boolean goNext = false;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (goNext) break;
                for (int j = 0; j < m; j++) {
                    if (ice[i][j] != 0) {
                        year++;
                        moveCnt = 0;
                        dfs(i, j);
                        setIce();
                        goNext = true;
                        break;
                    }
                }
            }
            if (iceCount == 0 || (moveCnt != iceCount)) break;
            iceCount = newIceCount;
            goNext = false;
        }

        System.out.println(iceCount == 0 ? 0 : year - 1);

        br.close();
    }

    static void setIce() {
        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(newIce[i], 0, ice[i], 0, m);
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        moveCnt++;
        removeIce(i, j);
        for (int k = 0; k < 4; k++) {
            int newI = i + moveX[k];
            int newJ = j + moveY[k];
            if (!visited[newI][newJ] && ice[newI][newJ] != 0) {
                dfs(newI, newJ);
            }
        }
    }

    static void removeIce(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int newI = i + moveX[k];
            int newJ = j + moveY[k];
            if (ice[newI][newJ] == 0 && newIce[i][j] > 0) newIce[i][j]--;
        }
        if (newIce[i][j] == 0) newIceCount--;
    }
}