import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] paper;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        countColor(0, 0, n);

        System.out.println(white + "\n" + blue);
    }

    static void countColor(int i, int j, int size) {
        if (checkColor(i, j, size)) {
            if (paper[i][j]==0) white++;
            else blue++;
            return;
        }

        countColor(i, j, size / 2);
        countColor(i, j + size / 2, size / 2);
        countColor(i + size / 2, j, size / 2);
        countColor(i + size / 2, j + size / 2, size / 2);
    }

    static boolean checkColor(int i, int j, int size) {
        int color = paper[i][j];
        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (paper[k][l] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}