import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findMax(i, j);
            }
        }
        System.out.println(max);
        br.close();
    }

    private static void findMax(int i, int j) {
        int total = 0;
        if (j + 3 < m) {
            for (int k = 0; k < 4; k++) {
                total += paper[i][j + k];
            }
            max = Math.max(max, total);
        }
        total = 0;
        if (i + 3 < n) {
            for (int k = 0; k < 4; k++) {
                total += paper[i + k][j];
            }
            max = Math.max(max, total);
        }
        total = 0;
        if (i + 1 < n && j + 1 < m) {
            for (int k = 0; k < 2; k++) {
                for (int l = 0; l < 2; l++) {
                    total += paper[i + k][j + l];
                }
            }
            max = Math.max(max, total);
        }
        if (i + 2 < n && j + 1 < m) {
            total = 0;
            total += paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1] + paper[i + 2][j];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j];
            max = Math.max(max, total);
        }
        if (i + 1 < n && j + 2 < m) {
            total = 0;
            total += paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i][j + 2];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
            max = Math.max(max, total);
            total = 0;
            total += paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2] + paper[i][j + 2];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
            max = Math.max(max, total);
        }

        if (i + 2 < n && j + 1 < m) {
            total = 0;
            total += paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j] + paper[i + 2][j];
            max = Math.max(max, total);
        }
        if (i + 1 < n && j + 2 < m) {
            total = 0;
            total += paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 1] + paper[i][j + 2];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
            max = Math.max(max, total);
        }

        if (i + 1 < n && j + 2 < m) {
            total = 0;
            total += paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i][j + 2];
            max = Math.max(max, total);
            total = 0;
            total += paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 1] + paper[i + 1][j + 2];
            max = Math.max(max, total);
        }
        if (i + 2 < n && j + 1 < m) {
            total = 0;
            total += paper[i + 1][j] + paper[i + 1][j + 1] + paper[i][j + 1] + paper[i + 2][j + 1];
            max = Math.max(max, total);
            total = 0;
            total += paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 1][j + 1];
            max = Math.max(max, total);
        }
    }
}