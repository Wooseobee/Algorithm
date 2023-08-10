import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, k, min = Integer.MAX_VALUE;
    private static int[] order;
    private static int[][] arr, op;
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        k = Integer.parseInt(in[2]);

        arr = new int[n][m];
        op = new int[k][3];
        order = new int[k];

        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }

        for (int i = 0; i < k; i++) {
            in = br.readLine().split(" ");
            op[i][0] = Integer.parseInt(in[0]);
            op[i][1] = Integer.parseInt(in[1]);
            op[i][2] = Integer.parseInt(in[2]);
        }

        perm(0, 0);
        System.out.println(min);
        br.close();
    }

    private static void perm(int depth, int flag) {
        if (depth == k) {
            int[][] tmpArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                tmpArr[i] = Arrays.copyOf(arr[i], m);
            }
            rotateWithOrder(tmpArr);
            calMin(tmpArr);
            return;
        }
        for (int i = 0; i < k; i++) {
            if ((flag & 1 << i) != 0) continue;
            order[depth] = i;
            perm(depth + 1, flag | 1 << i);
        }
    }

    private static void rotateWithOrder(int[][] tmpArr) {
        for (int o : order) {
            int r = op[o][0];
            int c = op[o][1];
            int s = op[o][2];

            rotate(r, c, s, tmpArr);
        }
    }

    private static void rotate(int r, int c, int s, int[][] tmpArr) {
        int i1 = r - s - 1;
        int j1 = c - s - 1;
        int i2 = r + s - 1;
        int j2 = c + s - 1;
        int num = Math.min(i2 - i1, j2 - j1) / 2;

        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = Arrays.copyOf(tmpArr[i], m);
        }

        for (int i = i1, j = j1, k = 0; k < num; i++, j++, k++) {
            int temp = tmp[i + 1][j];
            int prevI = i, prevJ = j;
            int dir = 0;
            int nowI = i + dx[dir], nowJ = j + dy[dir];

            while (!(nowI == i && nowJ == j)) {
                tmpArr[nowI][nowJ] = tmp[prevI][prevJ];
                prevI = nowI;
                prevJ = nowJ;

                int newI = nowI + dx[dir];
                int newJ = nowJ + dy[dir];

                if (!(newI >= i && newJ >= j && newI <= i2 - k && newJ <= j2 - k)) {
                    dir = (dir + 1) % 4;
                }
                nowI += dx[dir];
                nowJ += dy[dir];
            }

            tmpArr[nowI][nowJ] = temp;
        }
    }

    private static void calMin(int[][] tmpArr) {
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                total += tmpArr[i][j];
            }
            min = Math.min(min, total);
        }
    }
}