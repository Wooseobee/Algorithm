import java.io.*;
import java.util.*;

public class Main {
    static int n, p1 = 0, p2 = 0, p3 = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0, 0, n);
        System.out.println(p1 + "\n" + p2 + "\n" + p3);
        br.close();
    }

    static void dfs(int i, int j, int size) {
        if (checkPaper(i, j, size)) {
            if (paper[i][j] == -1) {
                p1++;
            } else if (paper[i][j] == 0) {
                p2++;
            } else {
                p3++;
            }
            return;
        }
        int newSize = size / 3;
        
        dfs(i, j, newSize);
        for (int k = 1; k < 3; k++) {
            dfs(i + (newSize * k), j, newSize);
            dfs(i, j + (newSize * k), newSize);
            dfs(i + (newSize * k), j + (newSize * k), newSize);
        }
        dfs(i + (newSize * 2), j + (newSize), newSize);
        dfs(i + (newSize), j + (newSize * 2), newSize);
    }

    private static boolean checkPaper(int i, int j, int size) {
        int color = paper[i][j];
        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (paper[k][l] != color) return false;
            }
        }
        return true;
    }
}