import java.io.*;
import java.util.Arrays;

public class Main {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        star = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(star[i], ' ');
        }

        makeStar(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static void makeStar(int i, int j, int size) {
        if (size == 1) {
            star[i][j] = '*';
            return;
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (!(k == 1 && l == 1)) {
                    makeStar(i + (size / 3) * k, j + (size / 3) * l, size / 3);
                }
            }
        }
    }
}