import java.io.*;
import java.util.*;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stars = new char[n][n * 2 - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(stars[i], ' ');
        }

        solution(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void solution(int i, int j, int size) {
        if (size == 3) {
            stars[i][j] = '*';
            stars[i + 1][j - 1] = stars[i + 1][j + 1] = '*';
            for (int k = 2; k >= -2; k--) {
                stars[i + 2][j - k] = '*';
            }
            return;
        }

        solution(i, j, size / 2);
        solution(i + size / 2, j - size / 2, size / 2);
        solution(i + size / 2, j + size / 2, size / 2);
    }
}