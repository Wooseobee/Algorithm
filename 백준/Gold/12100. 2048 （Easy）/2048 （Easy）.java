import java.io.*;
import java.util.*;

public class Main {
    static int n, max;
    static int[] cases = new int[5];
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;

        backTracking(0);

        System.out.println(max);
        br.close();
    }

    private static void backTracking(int depth) {
        if (depth == 5) {
            moveBlock();
            return;
        }

        for (int i = 0; i < 4; i++) {
            cases[depth] = i;
            backTracking(depth + 1);
        }
    }

    private static void moveBlock() {
        int[][] tmp = new int[n][n];
        boolean[][] merged = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, tmp[i], 0, n);
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(merged[j], false);
            }
            switch (cases[i]) {
                case 0:
                    for (int j = 0; j < n; j++) {
                        int cnt = 0;
                        for (int k = 0; k < n; k++) {
                            if (tmp[j][k] != 0) {
                                if (cnt != 0 && !merged[j][cnt - 1] && tmp[j][cnt - 1] == tmp[j][k]) {
                                    tmp[j][cnt - 1] *= 2;
                                    tmp[j][k] = 0;
                                    merged[j][cnt - 1] = true;
                                    continue;
                                }
                                tmp[j][cnt++] = tmp[j][k];
                                if (cnt - 1 != k) {
                                    tmp[j][k] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    for (int j = 0; j < n; j++) {
                        int cnt = 0;
                        for (int k = 0; k < n; k++) {
                            if (tmp[k][j] != 0) {
                                if (cnt != 0 && !merged[cnt - 1][j] && tmp[cnt - 1][j] == tmp[k][j]) {
                                    tmp[cnt - 1][j] *= 2;
                                    tmp[k][j] = 0;
                                    merged[cnt - 1][j] = true;
                                    continue;
                                }
                                tmp[cnt++][j] = tmp[k][j];
                                if (cnt - 1 != k) {
                                    tmp[k][j] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (int j = n - 1; j >= 0; j--) {
                        int cnt = n - 1;
                        for (int k = n - 1; k >= 0; k--) {
                            if (tmp[j][k] != 0) {
                                if (cnt != n - 1 && !merged[j][cnt + 1] && tmp[j][cnt + 1] == tmp[j][k]) {
                                    tmp[j][cnt + 1] *= 2;
                                    tmp[j][k] = 0;
                                    merged[j][cnt + 1] = true;
                                    continue;
                                }
                                tmp[j][cnt--] = tmp[j][k];
                                if (cnt + 1 != k) {
                                    tmp[j][k] = 0;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (int j = n - 1; j >= 0; j--) {
                        int cnt = n - 1;

                        for (int k = n - 1; k >= 0; k--) {
                            if (tmp[k][j] != 0) {
                                if (cnt != n - 1 && !merged[cnt + 1][j] && tmp[cnt + 1][j] == tmp[k][j]) {
                                    tmp[cnt + 1][j] *= 2;
                                    tmp[k][j] = 0;
                                    merged[cnt + 1][j] = true;
                                    continue;
                                }
                                tmp[cnt--][j] = tmp[k][j];
                                if (cnt + 1 != k) {
                                    tmp[k][j] = 0;
                                }
                            }
                        }
                    }
                    break;
            }
        }
        countMax(tmp);
    }

    private static void countMax(int[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, tmp[i][j]);
            }
        }
    }
}