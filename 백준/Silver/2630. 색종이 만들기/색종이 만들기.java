import java.io.*;

public class Main {
    static int[][] paper;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];


        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        count(0, 0, n);

        System.out.println(white + "\n" + blue);
        br.close();
    }

    static void count(int i, int j, int size) {
        if (sameColor(i, j, size)) {
            if (paper[i][j] == 1) blue++;
            else white++;
            return;
        }
        count(i, j, size / 2);
        count(i, j + size / 2, size / 2);
        count(i + size / 2, j, size / 2);
        count(i + size / 2, j + size / 2, size / 2);
    }

    static boolean sameColor(int i, int j, int size) {
        int color = paper[i][j];
        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (paper[k][l] != color) return false;
            }
        }
        return true;
    }
}